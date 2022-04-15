package com.example.junitreport;

import java.util.Date;

/**
 * @author Gohar Ohanyan. Created on 4/12/2022.
 */
public class Person {
    private String name;
    private int age;
    private Gender gender;

    public Person() {
        System.out.println("person constructor");
    }

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    int calculateAge(int year){
        return year - new Date().getYear() + this.age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}