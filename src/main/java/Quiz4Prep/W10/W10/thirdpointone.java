package Quiz4Prep.W10.W10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Macka2 {
    private final String name;
    private int age;

    public Macka2(String name, int age) {
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
        System.out.println("I'm public and static");
    }
    public void meow() {
        System.out.println("meow");
    }
    public void saySomething(String something) {
        System.out.println("I said something ".concat(something));
    }
    private void heyThisIsPrivate() {
        System.out.println("How did you call this?");
    }


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Macka2 macka = new Macka2("Cici",20);

        Method[] mackaMethod = macka.getClass().getDeclaredMethods();
        for (Method all : mackaMethod) {
            System.out.println("Metoda: " + all.getName());

            if(all.getName().equals("meow")) {
                all.invoke(macka);
            }
            else if(all.getName().equals("saySomething")) {
                all.invoke(macka,"NIGGA");
            }
            else if(all.getName().equals("heyThisIsPrivate")) {
                all.setAccessible(true);
                all.invoke(macka);
            }
            else if (all.getName().equals("thisIsPublicStaticMethod")) {
                all.invoke(null); // static methods dont need OBJECTS
            }
        }

    }
}