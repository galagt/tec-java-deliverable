package models;

public class ScholarshipStudent extends Student {
    public ScholarshipStudent(String name, double grade, int age) {
        super(name, grade, age);
    }

    @Override
    public String getType(){
        return "Scholarship";
    }
}
