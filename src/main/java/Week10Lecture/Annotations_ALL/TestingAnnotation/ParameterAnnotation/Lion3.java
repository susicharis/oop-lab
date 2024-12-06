package Week10Lecture.Annotations_ALL.TestingAnnotation.ParameterAnnotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public record Lion3 (String name) {
    @RunImmediatelyNTimes(times = 3)
    public void roar() {
        System.out.println(name + " says Roar!");
    }
}


class Main4 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Lion3 lion = new Lion3("Susic");


        for (Method method : lion.getClass().getDeclaredMethods()) {
            if(method.isAnnotationPresent(RunImmediatelyNTimes.class)) {
                RunImmediatelyNTimes annotation = method.getAnnotation(RunImmediatelyNTimes.class);

                for (int i = 0; i < annotation.times(); i ++) {
                    method.invoke(lion);
                }
            }
        }
    }
}