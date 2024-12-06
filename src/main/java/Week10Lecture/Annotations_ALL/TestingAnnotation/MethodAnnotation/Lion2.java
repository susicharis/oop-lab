package Week10Lecture.Annotations_ALL.TestingAnnotation.MethodAnnotation;

import java.lang.reflect.Method;

public record Lion2(String name) {
    @RunImmediately
    public void saySomething() {
        System.out.println("Lion method saySomething");
    }
    public void saySomethingButDontRun() {
        System.out.println("Lion method saySomethingButDontRun");
    }
}

class Main3 {
    public static void main(String[] args) throws Exception{
        Lion2 lion = new Lion2("Harke");

        for(Method metoda : lion.getClass().getDeclaredMethods()) {
            if(metoda.isAnnotationPresent(RunImmediately.class)) {
                System.out.println("Method name is : " + metoda.getName());
                metoda.invoke(lion);
            }
        }
    }
}
