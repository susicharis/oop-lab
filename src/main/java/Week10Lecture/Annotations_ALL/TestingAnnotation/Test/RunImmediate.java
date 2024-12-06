package Week10Lecture.Annotations_ALL.TestingAnnotation.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface RunImmediate {
}

record Lavica(String name) {
    @RunImmediate
    public void saySomething() {
        System.out.println("My name is : " + name);
    }

    public void saySomethingButDontRun() {
        System.out.println("Hehehe SUIIII I DONT RUN BOII");
    }
}

class TestPls {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Lavica lavica = new Lavica("Becira");

        for(Method m : lavica.getClass().getDeclaredMethods()) {
            if(m.isAnnotationPresent(RunImmediate.class)) {
                m.invoke(lavica);
            }
        }


    }
}