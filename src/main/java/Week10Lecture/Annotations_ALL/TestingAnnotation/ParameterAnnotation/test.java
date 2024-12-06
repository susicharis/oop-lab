package Week10Lecture.Annotations_ALL.TestingAnnotation.ParameterAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface test {
    int times();
}

record Lion2(String name) {
    @test(times = 3)
    public static void roar() {
        System.out.println("ROARRR BIGNIGGA!");
    }
}

/*
We want to develop a program that will check if the annotation is present above the
 method and if it is we want to run it specified number of times
 */

class Lion2Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // Posto ide preko objekta kreiramo prvo objekat da bi sve ostalo odradili
        Lion2 lion = new Lion2("Harko");

        for(Method m : lion.getClass().getDeclaredMethods()) {
            if(m.isAnnotationPresent(test.class)) {
                test annParameter = m.getAnnotation(test.class);

                for(int i = 0; i <= annParameter.times(); i++) {
                    m.invoke(lion);
                }

            }
        }

    }
}
