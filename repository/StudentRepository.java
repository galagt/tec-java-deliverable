package repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import models.Student;

public class StudentRepository {
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }

    public Student findStudent(String name){
        for (Student student : students) {
            if (student.getName().equals(name)){
                return student;
            }
        }
        throw new NoSuchElementException("No student with given name found");
    }

    public Iterator<Student> getStudentIterator(){
        List<Student> immutableList = Collections.unmodifiableList(students);
        return immutableList.iterator();
    }

    public double[] getGradesArray(){
        double[] grades = new double[students.size()];
        for (int i = 0; i < students.size(); i++) {
            grades[i] = students.get(i).getGrade();
        }
        return grades;
    }
    
}
