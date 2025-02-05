package Quiz4Prep.W10.W10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ImportantStringTrustMe {

}

class Fox {
    @ImportantStringTrustMe
    private String name;
    private int numOfLegs;

    public Fox(String name, int numOfLegs) {
        this.name = name;
        this.numOfLegs = numOfLegs;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Fox lisica = new Fox("Lukica",4);

        for(Field field : lisica.getClass().getDeclaredFields()) {

            if(field.isAnnotationPresent(ImportantStringTrustMe.class)) {
                field.setAccessible(true);
                Object value = field.get(lisica);

                if(value instanceof String myFoxName) {
                    System.out.println("Field name is : " + field.getName() + " and its value is : " + myFoxName);
                }
            }

        }



    }
}