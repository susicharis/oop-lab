package Week10Lecture.Reflections_ALL;

import java.lang.reflect.Field;

class Cat {
    private final String name;
    private int age;

    public Cat(String name, int age) {
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

class RealestMain {
    public static void main(String[] args) throws IllegalAccessException {
        Cat firstCat = new Cat("Cicko",20);


        Field[] firstField = firstCat.getClass().getDeclaredFields();
        for (Field f : firstField) {
            System.out.println(f.getName());
        }

        // Accessing final attribute and changing it !
        for (Field access : firstField) {
            if (access.getName().equals("name")) {
                access.setAccessible(true);
                access.set(firstCat,"Micko Malisa");
            }
        }



        System.out.println(firstCat.getName());





    }
}