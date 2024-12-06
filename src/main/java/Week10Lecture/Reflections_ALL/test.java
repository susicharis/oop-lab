package Week10Lecture.Reflections_ALL;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Macka {
    private final String name;
    private int age;

    public Macka(String name, int age) {
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

    public static void firstMethod() {
        System.out.println("This is first method! (STATIC) ");
    }

    public void secondMethod(String second) {
        System.out.println("This is second method! (NON-STATIC)");
    }

    private void thirdMethod() {
        System.out.println("This is third method (PRIVATE)");
    }




    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Macka cat = new Macka("Cici", 15);

        // pomocu ovog mozemo koristiti svasta iz Refleksije
        cat.getClass();

        Field[] getFields = cat.getClass().getDeclaredFields();
        for (Field f : getFields) {
            System.out.println("Koristili smo fields : " + f.getName() + "\n");
        }

        System.out.println();
        System.out.println("Prije promjene final atributa : " + cat.getName());




        for (Field changeName : getFields) {
            if (changeName.getName().equals("name")) {
                changeName.setAccessible(true);
                changeName.set(cat,"Becko");
            }
        }

        System.out.println("Poslije promjene final atributa: " + cat.getName());


        System.out.println();
        System.out.println();
        System.out.println("Using Reflections on METHODS! \n");

        Method[] catMethods = cat.getClass().getDeclaredMethods();
        for (Method all : catMethods) {
            System.out.println("Method in our class: " + all.getName());
        }

        // Invokeanje metoda

        for (Method allAgain : catMethods) {
            if (allAgain.getName().equals("firstMethod")) {
                allAgain.invoke(cat);
            }
        }



    }
}
