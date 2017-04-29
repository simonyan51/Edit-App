package com.example.editprofile;

/**
 * Created by simonyan51 on 4/28/17.
 */

public enum Gender {
    MALE("M"), FEMALE("F");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
