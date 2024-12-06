package Week10Lecture.Annotations_ALL.TestingAnnotation.ParameterAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RunImmediatelyNTimes {
    // in our annotation we have declared a method called times
    // we can give default value to our methods - IF WE DONT WE HAVE TO PASS THE PARAMETER TO ANNOTATION
    int times();
}
