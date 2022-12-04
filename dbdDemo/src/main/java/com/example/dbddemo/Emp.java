package com.example.dbddemo;

public class Emp {

    private String Name;
    private int ID,Age;


    public Emp(String name, int id, int age) {
        Name = name;
        ID = id;
        Age = age;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
