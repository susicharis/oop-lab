package Week10Lecture.Annotations_ALL.TestingAnnotation.FieldAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface test {
}





class SecondFox {
    @test
    private String name;
    private int numOfLegs;

    public SecondFox(String name, int numOfLegs) {
        this.name = name;
        this.numOfLegs = numOfLegs;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumOfLegs() {
        return numOfLegs;
    }
    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }



    public static void main(String[] args) throws IllegalAccessException {
        SecondFox fox = new SecondFox("Lukica",4);

        Field[] getFoxFields = fox.getClass().getDeclaredFields();

        for(Field f : getFoxFields) {
            if(f.isAnnotationPresent(test.class)) {
                f.setAccessible(true);

                Object value = f.get(fox);
                if (value instanceof String getFox) {
                    System.out.println("Field name is : " + f.getName() + " and its value is : " + getFox);
                }
            }
        }

    }
}