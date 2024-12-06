package Week10Lecture.Annotations_ALL.TestingAnnotation.FieldAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImportantString {

}




class Fox {
    @ImportantString
    private String name;
    private int numOfLegs;

    public Fox(String name, int numOfLegs) {
        this.name = name;
        this.numOfLegs = numOfLegs;
    }

}

class Main5 {
    public static void main(String[] args) throws IllegalAccessException {
        Fox fox = new Fox("Bokisa",4);

        for (Field fields : fox.getClass().getDeclaredFields()) {
            if(fields.isAnnotationPresent(ImportantString.class)) {
                fields.setAccessible(true);
                Object value = fields.get(fox);

                if(value instanceof String myFoxName) {
                    System.out.println("The field name is: " + fields.getName() + " and its value in uppercase is " + myFoxName.toUpperCase());
                }
            }
        }
    }
}