package org.example;

public class Enums {

    public static void main(String[] args) {
        Gender gender = Gender.MALE;
        System.out.println(gender);
    }
}

enum Gender {
    MALE, FEMALE
}
