package FinalExamPrep.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface RunImmNTimes {
    int times();
}


record Pumba(String name) {
    @RunImmNTimes(times = 5)
    public void saySomething() {
        System.out.println(name + " said something.");
    }
}

class Main03 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Pumba pumba = new Pumba("Timur");

        for(Method method : pumba.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmNTimes.class)) {
                RunImmNTimes annotation = method.getAnnotation(RunImmNTimes.class);
                for (int i = 0; i < annotation.times(); i++) {
                    method.invoke(pumba);
                }
            }
        }

    }
}