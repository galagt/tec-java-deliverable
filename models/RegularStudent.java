package models;

public class RegularStudent extends Student {
    public RegularStudent(String name, double grade, int age) {
        super(name, grade, age);
    }

    @Override
    public String getType(){
        return "Regular";
    }
}
