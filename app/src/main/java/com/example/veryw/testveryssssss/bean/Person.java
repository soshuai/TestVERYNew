package com.example.veryw.testveryssssss.bean;

/**
 * Created by veryw on 2018/7/25.
 */

public class Person{
    private String name;
    private int age;
    private boolean boy;

    public Person() {
    }

    public Person(String name, int age, boolean boy) {
        this.name = name;
        this.age = age;
        this.boy = boy;
    }

    public Object clone(){
        Person o=null;
        try {
            o= (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isBoy() {
        return boy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBoy(boolean boy) {
        this.boy = boy;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boy=" + boy +
                '}';
    }
}
