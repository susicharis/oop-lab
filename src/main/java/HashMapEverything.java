import java.util.HashMap;
import java.util.Map;

class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> studentMarks = new HashMap<>();

        studentMarks.put("Haris",95);
        studentMarks.put("Tarik",95);
        studentMarks.put("Sumea",100);

        // Pristup podatcima preko keya
        System.out.println("Haris marks: " + studentMarks.get("Haris"));

        // Provjerava da li key postoji
        if(studentMarks.containsKey("Tarik")) {
            System.out.println("Tarik marks: " + studentMarks.get("Tarik"));
        }

        // Iteracija kroz sve keyeve i vrijednosti
        for(String key : studentMarks.keySet()) {
            System.out.println("Student: " + key + ", Marks: " + studentMarks.get(key));
        }

        // Uklanjanje unosa
        studentMarks.remove("Sumea");
        System.out.println("After Removal: " + studentMarks);

        // Prolazak kroz sve unose ( i key i value )
        for(Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println("Student: " + entry.getKey() + " , Marks: " + entry.getValue());
        }

        // Vracanje svih values
        for(Integer marks : studentMarks.values()) {
            System.out.println("Only marks: " + marks);
        }

        // Zamjena vrijednosti
        studentMarks.replace("Tarik",95,85);

        // Provjera koliki je size
        System.out.println("Size: " + studentMarks.size());

        // Provjerava vrijednosti
        if(studentMarks.containsValue(95)) {
            System.out.println("someone scored 95!");
        }
    }
}