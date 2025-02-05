package FinalExamPrep.Annotations;

import Week10Lecture.Annotations_ALL.TestingAnnotation.VeryImportant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface VeryImportant2{
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface RunImmediately {
}




@VeryImportant2
class Lion {
    String name;

    public Lion(String name) {
        this.name = name;
    }
}

record Lions(String name) {
    @RunImmediately
    public void saySomething() {
        System.out.println(name + " said something");
    }
    public void sayItButDontRun() {
        System.out.println(name + " also said but doesn't run");
    }
}


class Main02 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Lion lav = new Lion("Harke");
        System.out.println(lav.getClass().isAnnotationPresent(VeryImportant2.class));

        System.out.println("\n RunImmediately Interface: \n");
        Lions secondLav = new Lions("Ekrah");
        for(Method method : secondLav.getClass().getDeclaredMethods()) {
            if(method.isAnnotationPresent(RunImmediately.class)) {
                method.invoke(secondLav);
            }
        }
    }
}