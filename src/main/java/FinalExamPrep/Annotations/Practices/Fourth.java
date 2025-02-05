package FinalExamPrep.Annotations.Practices;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface NotNull {
}


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Range {
    int min();
    int max();
}

class UserRegistration {
    @NotNull
    String name;

    @NotNull
    @MaxLength(value = 50)
    String email;

    @NotNull
    @Range(min = 1, max = 99)
    String age;

    public UserRegistration(String name, String email, String age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public String getAge() {
        return this.age;
    }
}


class Validator {

    public static void checkValidation(Object obj) throws IllegalAccessException {
        Class<?> evClass = obj.getClass();
        boolean hasErrors = false;

        for(Field f : evClass.getDeclaredFields()) {
            f.setAccessible(true);
            Object value = f.get(obj);

            if(f.isAnnotationPresent(NotNull.class) && value == null) {
                System.out.println("Field not validated! " + f.getName() + " cannot be null");
                hasErrors = true;
            }

            if(f.isAnnotationPresent(MaxLength.class) && value instanceof String) {
                int maxLength = f.getAnnotation(MaxLength.class).value();

            }
        }



    }
}
