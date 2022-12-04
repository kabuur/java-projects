package com.example.dbdtry;

public class Emp {

  private   String Name;
  private  int Id,Age;

    public Emp(String name, int id, int age) {
        Name = name;
        Id = id;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
