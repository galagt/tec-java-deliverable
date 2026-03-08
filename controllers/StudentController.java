package controllers;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.BiFunction;

import models.RegularStudent;
import models.ScholarshipStudent;
import models.Student;
import repository.StudentRepository;

public class StudentController {
    private StudentRepository studentRepository;
    private Scanner scanner;
    public StudentController(StudentRepository repository, Scanner scanner){
        studentRepository = repository;
        this.scanner = scanner;
    }


        //Returns the group average
    private static double calculateAverage(double[] grades){
        return sumGrades(grades, 0) / grades.length;
    }


    private static double findExtreme(double[] grades, double startOfInterval, BiFunction<Double, Double, Boolean> func){
        double extreme = startOfInterval;
        for (double d : grades) {
            extreme = func.apply(d, extreme) ? d : extreme;
        }
        return extreme;
    }


    //Returns the maximum grade
    private static double highestGrade(double[] grades){
        return findExtreme(grades, 0.0, (a, b) -> a > b);
    }


    //Returns the minimum grade
    private static double lowestGrade(double[] grades){
        return findExtreme(grades, 10.0, (a, b) -> a < b);
    }


    //Counts how many passed (grade ≥ 6.0)
    private static int countPassed(double[] grades){
        int count = 0;
        for (double d : grades) {
            if (d >= 6.0) ++count;
        }
        return count;
    }


    //Recursive — adds grades one by one
    private static double sumGrades(double[] grades, int i){
        if (i == grades.length) return 0;
        return grades[i] + sumGrades(grades, i + 1);
    }


    public void registerStudent(){
        System.out.println("Registering student:");
        System.out.print("1) Name: ");
        String name = scanner.next();
        Integer age = null;
        while (age == null){
            System.out.print("2) Age: ");
            try {
                age = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Not a number.");
                scanner.next();
            }
        }
        Double grade = null;
        while (grade == null){
            System.out.print("3) Grade: ");
            try{
                grade = scanner.nextDouble();
            } catch (InputMismatchException e){
                System.out.println("ERROR: Not a number.");
                scanner.next();
            }
            if (grade != null && (grade < 0 || grade > 10.0)){
                System.out.println("ERROR: Grade out of range 0.0 - 10.0.");
                grade = null;
            }
        }
        Integer studentType = null;
        while (studentType == null){
            System.out.print("4) Student type 1 - regular, 2 - scholarship: ");
            try{
                studentType = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("ERROR: Not a number.");
                scanner.next();
            }
            if (studentType != null && (studentType < 1 || studentType > 2)){
                System.out.println("ERROR: Option out of range.");
                studentType = null;
            }
        }
        Student student;
        switch (studentType) {
            case 1:
                student = new RegularStudent(name, grade, age);
                break;
        
            case 2:
                student = new ScholarshipStudent(name, grade, age);
                break;
            default:
                student = new RegularStudent(name, grade, age);
                break;
        }
        studentRepository.addStudent(student);
        System.out.println("Successfully registered student " + student.toString() + ".");
    }


    public void viewGrades() {
        Iterator<Student> iterator = studentRepository.getStudentIterator();
        while (iterator.hasNext()) {
            iterator.next().displayInfo(true);
        }
    }


    public void viewStatistics() {
        double[] grades = studentRepository.getGradesArray();
        System.out.println("Statistics:");
        System.out.println(" Average: " + calculateAverage(grades));
        System.out.println(" Highest grade: " + highestGrade(grades));
        System.out.println(" Lowest grade: " + lowestGrade(grades));
        System.out.println(" Students passed: " + countPassed(grades));
    }


    public void searchStudent() {
        System.out.print("1) Name: ");
        String name = scanner.next();
        try {
            studentRepository.findStudent(name).displayInfo();
        } catch (NoSuchElementException e) {
            System.out.println("ERROR: No student with that name found.");
        }
    }
}
