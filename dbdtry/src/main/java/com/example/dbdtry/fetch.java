package com.example.dbdtry;

public class fetch {


    private  String name;
    private  int Age,id;

    public fetch(String name, int ade, int id) {
        this.name = name;
        this.Age = ade;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
