package Week10Lecture.Annotations_ALL.TestingAnnotation;

// Ova klasa je oznacena kao "Veoma vazna"
// Zbog RETENTIONA(RUNTIME), mozemo provjeriti prisustvo ove Anotacije koristeci Reflection
@VeryImportant
public record Lion(String name) {
}

class Main2 {
    public static void main(String[] args) {
        Lion lion = new Lion("Haris");

        // Check if annotation is used on class Lion
        System.out.println(lion.getClass().isAnnotationPresent(VeryImportant.class));
        /*
        lion.getClass() - dobija referencu na klasu Lion
        isAnnotationPresent(...) - provjerava da li je klasa Lion anotirana sa VeryImportant
         */
    }
}