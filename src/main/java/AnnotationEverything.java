


import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Definisemo Anotaciju
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Info {
    String author() default "Harkiz";
    int version() default 1;
}

// Class sa annotations

@Info(author = "Haris",version = 2)
class AnnotatedClass {
    public void annotatedMethod() {
        System.out.println("This is annotated method");
    }

    @Info(author = "Sumea,version = 3")
    public String annotatedField = "Annotated Field";
}

class AnnExample {
    public static void main(String[] args) throws Exception {
        // Dohvatamo klasu
        Class<?> klasa = AnnotatedClass.class;

        // Provjera da li klasa posjeduje Anotaciju
        if(klasa.isAnnotationPresent(Info.class)) {
            System.out.println("Class has info annotation");
        }

        // Dohvatanje instance anotacije na klasi
        Info classAnn = klasa.getAnnotation(Info.class);
        if(classAnn != null) {
            System.out.println("Author: " + classAnn.author());
            System.out.println("Version: " + classAnn.version());
        }

        // Dohvatanje metoda i provjera za anotacije
        for(Method method : klasa.getDeclaredMethods()) {
            if(method.isAnnotationPresent(Info.class)) {
                System.out.println("Method " + method.getName() + " has Info annotation");
                Info methodAnn = method.getAnnotation(Info.class);
                System.out.println("Author: " + methodAnn.author());
                System.out.println("Version: " + methodAnn.version());
            }
        }

        // Dohvatanje fields & provjera za anotacije
        for (Field f : klasa.getDeclaredFields()) {
            if(f.isAnnotationPresent(Info.class)) {
                System.out.println("Field " + f.getName() + " is annotation present(info)");
                Info fieldAnn = f.getAnnotation(Info.class);
                System.out.println("Author: " + fieldAnn.author());
                System.out.println("Version: " + fieldAnn.version());
            }
        }

        // Dohvatanje svih anotacija klase
        Annotation[] classAnnotations = klasa.getAnnotations();
        System.out.println("\nAll Annotations on the Class:");
        for (Annotation annotation : classAnnotations) {
            System.out.println(annotation);
        }

        // Dohvatanje svih anotacija na metodi
        Method annotatedMethod = klasa.getMethod("annotatedMethod");
        Annotation[] methodAnnotations = annotatedMethod.getAnnotations();
        System.out.println("\nAll Annotations on the Method:");
        for (Annotation annotation : methodAnnotations) {
            System.out.println(annotation);
        }

        // Dohvatanje svih anotacija na polju
        Field annotatedField = klasa.getDeclaredField("annotatedField");
        Annotation[] fieldAnnotations = annotatedField.getAnnotations();
        System.out.println("\nAll Annotations on the Field:");
        for (Annotation annotation : fieldAnnotations) {
            System.out.println(annotation);
        }

    }
}


