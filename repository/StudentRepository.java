package repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import models.Student;

public class StudentRepository {
    ArrayList<Student> students = new ArrayList<>();

    /**
     * Add new student to the in memory database
     * @param student Student to be added to the database.
     */
    public void addStudent(Student student){
        students.add(student);
    }


    /**
     * Find specific student in the database by name
     * @param name name of the student to be found
     * @throws NoSuchElementException if no element was found
     * @return Student if student was found with given name
     */
    public Student findStudent(String name){
        for (Student student : students) {
            if (student.getName().equals(name)){
                return student;
            }
        }
        throw new NoSuchElementException("No student with given name found");
    }

    /**
     * Get immutable iterator to the underlying database.
     * @return Iterator for students in the database
     */
    public Iterator<Student> getStudentIterator(){
        List<Student> immutableList = Collections.unmodifiableList(students);
        return immutableList.iterator();
    }

    /**
     * Get anonymized array of grades for statistical analysis.
     * @return array of grades
     */
    public double[] getGradesArray(){
        double[] grades = new double[students.size()];
        for (int i = 0; i < students.size(); i++) {
            grades[i] = students.get(i).getGrade();
        }
        return grades;
    }
    
}
