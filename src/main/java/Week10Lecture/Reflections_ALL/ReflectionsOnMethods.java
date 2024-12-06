package Week10Lecture.Reflections_ALL;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class SecondCat {
    private final String name;
    private int age;

    public SecondCat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public static void thisIsPublicStaticMethod() {
        System.out.println("I'm public and static!");
    }
    public void meow() {
        System.out.println("meow!");
    }
    public void saySomething(String something) {
        System.out.println("I said something ".concat(something));
    }
    private void heyThisIsPrivate() {
        System.out.println("How did you call this?");
    }
}

class WhatMain {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        SecondCat myCat = new SecondCat("Micka",20);

        // vraca niz tipa Method[], koji sadrzi sve metode koje su deklarisane u klasi (i privatne i sve ostale)
        // AKO NEKA KLASA EXTENDA SECONDCAT KLASU - NECE NJENE METODE ISPISATI !

        Method[] catMethods = myCat.getClass().getDeclaredMethods();
        for (Method all : catMethods) {
            System.out.println(all.getName());


            if(all.getName().equals("meow")) {
                all.invoke(myCat);
            } else if(all.getName().equals("saySomething")) {
                all.invoke(myCat,"AW AW AW");
            } else if (all.getName().equals("heyThisIsPrivate")) {
                all.setAccessible(true);
                all.invoke(myCat); // private je pa nece raditi bez setAccessible
            } else if (all.getName().equals("thisIsPublicStaticMethod")) {
                all.invoke(null); // posto je static, ne trebamo proslijediti nikakav objekt
            }
        }

        Method[] catMethodsAgain = myCat.getClass().getMethods();
        Method[] catMethodsAgainAgain = myCat.getClass().getDeclaredMethods();





    }
}