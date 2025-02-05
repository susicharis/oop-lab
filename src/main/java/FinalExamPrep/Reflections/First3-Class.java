package FinalExamPrep.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Cars {
    private final String name;
    private int age;

    public Cars(String name, int age) {
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
        System.out.println("Im Public & STATIC!");
    }
    public void meow() {
        System.out.println("MEOW");
    }
    public void saySomething(String something) {
        System.out.println("I said something," .concat(something));
    }
    private void privateMethod() {
        System.out.println("How did you call this?");
    }
}


class Main01 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Cars cars = new Cars("BMW",4);
        cars.getClass();
        Field[] getFields =  cars.getClass().getDeclaredFields();

        // Getting fields (attributes from class)
        for (Field f : getFields) {
            System.out.println(f.getName());
        }

        // Accesing private final attributes and changing them
        for (Field field : getFields) {
            if(field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(cars,"MERCEDES");
            }
        }
        System.out.println(cars.getName());


        // Using Reflection on Methods
        System.out.println("\n Methods: \n");
        Method[] carMethods = cars.getClass().getDeclaredMethods();
        for(Method methods : carMethods) {
            System.out.println(methods.getName());
            if(methods.getName().equals("thisIsPublicStaticMethod")) {
                methods.invoke(null);
            } else if(methods.getName().equals("meow")) {
                methods.invoke(cars);
            } else if (methods.getName().equals("privateMethod")) {
                methods.setAccessible(true);
                methods.invoke(cars);
            }
        }


    }
}


