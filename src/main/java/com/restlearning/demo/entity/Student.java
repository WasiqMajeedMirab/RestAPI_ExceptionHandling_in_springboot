package com.restlearning.demo.entity;

public class Student {
    private String firstName,LastName;
    public Student(){

    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        LastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
