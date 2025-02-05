package Quiz4Prep.W10.W10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MostlyImportant {
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface RunImmediately {
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface RunNTimes {
    int times();
}




record Lion(String name) {
    public Lion(String name) {
        this.name = name;
    }

    @RunImmediately
    public void saySomething() {
        System.out.println("Lion says something.");
    }

    public void sayItButDontRun() {
        System.out.println("Lion says sayItButDontRun");
    }
    @RunNTimes(times = 5)
    public void runItMore() {
        System.out.println(this.name + " loves eating Zebras,trust bro...");
    }
}

class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Lion lion = new Lion("Pumba");
        System.out.println(lion.getClass().isAnnotationPresent(MostlyImportant.class));

        for(Method method : lion.getClass().getDeclaredMethods()) {
            if(method.isAnnotationPresent(RunImmediately.class)) {
                method.invoke(lion);
            }

            if(method.isAnnotationPresent(RunNTimes.class)) {
                RunNTimes times = method.getAnnotation(RunNTimes.class); // times sadrzi vrijednost atributa definisanih u @RunNTimes
                for(int i = 0; i <= times.times(); i++) { // .times() metoda omogucava pristup koliko ce puta uraditi nesto
                    method.invoke(lion);
                }
            }

        }


    }
}
