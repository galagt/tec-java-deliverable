package models;

public class Person {
    protected String name;
    protected int age;

    //Constructor is missing by my design, show of super contructor can be seen in regular and scholarship students

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }
}
