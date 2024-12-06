package Week10Lecture.Annotations_ALL.TestingAnnotation.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

// posto je public - mora se zvati kao i naziv "test.java"
public @interface test {
}


@test
class Lav {
    private String name;

    public Lav(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        Lav lavcina = new Lav("Harke");

        boolean testiramo = lavcina.getClass().isAnnotationPresent(test.class);
        System.out.println(testiramo);

    }
}