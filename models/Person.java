package models;

public class Person {
    protected String name;
    protected int age;

    //Constructor is missing by my design, show of super contructor can be seen in regular and scholarship students

    /**
     * Name getter
     * @return name of the Person
     */
    public String getName(){
        return this.name;
    }

    /**
     * Age getter
     * @return age of the Person
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Name setter
     * @param name of the Person
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Age setter
     * @param age of the Person
     */
    public void setAge(int age){
        this.age = age;
    }
}
