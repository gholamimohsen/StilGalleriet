package com.project.stilgalleriet.models;

public enum EGender {
    FEMALE, MALE, UNISEX;

    public static EGender fromString(String text){
        for (EGender gender: EGender.values()){
            if (gender.name().equalsIgnoreCase(text)){
                return gender;
            }
        }
        return null;
    }
}
