package models;
import constants.Constants;

public abstract class Student extends Person {
    private double grade;

    public Student(String name, double grade, int age){
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    public String toString(){
        return "Name: " + this.name + ", Age: " + this.age + ", Grade: " + this.grade;
    }

    public abstract String getType();
    
    // "Passed" or "Failed"
    public String getStatus(){
         return this.grade < Constants.PASSING_GRADE ? "Failed" : "Passed";
    }

    // shows name and grade
    public void displayInfo(){
        System.out.println(this.name + " " + this.grade);
    }    

    // also shows Passed/Failed                
    public void displayInfo(boolean showStatus){
        if (showStatus) System.out.println(this.name + " " + this.grade + " " + this.getStatus());
        else this.displayInfo();
    }    

    public double getGrade(){
        return this.grade;
    }
}
