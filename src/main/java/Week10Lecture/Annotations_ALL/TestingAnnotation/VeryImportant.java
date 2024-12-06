package Week10Lecture.Annotations_ALL.TestingAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Anotacija se moze koristiti samo na klasama,interfejsima, recordima,enumima
@Target(ElementType.TYPE)
/*  Anotacija ce biti u RUNTIME(tokom izvrsavanja programa) za Reflection
    Bez ove dole opcije, anotacija ne bi bila ukljucena u bytecodeu u obliku koji refleksija moze citati
    RETENTION - Definise koliko dugo anotacija ostaje dostupna !
 */
@Retention(RetentionPolicy.RUNTIME)
// Kreira novu custom anotaciju pod nazivom "VeryImportant"
public @interface VeryImportant {
}
