package com.example.editprofile;

import java.io.Serializable;

/**
 * Created by simonyan51 on 4/28/17.
 */

public class User implements Serializable {

    static final long serialVersionUID = -1;
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String gender;
    private int age;
    private String bio;

    public User(int id, String firstName, String lastName, String userName, String gender, int age, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
