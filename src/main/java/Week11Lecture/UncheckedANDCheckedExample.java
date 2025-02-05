package Week11Lecture;

// C:\Users\Haris\Desktop\kviz.txt
import java.io.FileNotFoundException;
import java.io.FileReader;

class Main {
    // Checked
    public static void readFile(String filename) {
        try {
            FileReader reader = new FileReader(filename);
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    // Checked
    public static void readFileThrowable(String filename) throws FileNotFoundException{
        FileReader reader = new FileReader(filename);
    }

    // Unchecked
    public static void printLength(String myString) {
        System.out.println(myString.length());
    }


    public static void main(String[] args) {
        printLength(null);
        // NullPointerException - NE MORAMO HANDLE THIS EXCEPTION jer je UNCHECKED (Desava se u Runtime)
    }
}