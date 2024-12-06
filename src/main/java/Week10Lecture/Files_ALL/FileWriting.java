package Week10Lecture.Files_ALL;
import java.io.*;

public class FileWriting {



    public static void ArrayFileWrite(String[] data) throws IOException {
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("C:\\Users\\Haris\\Desktop\\haris.txt"));

        for (String values : data) {
            writer2.write(values);
            writer2.newLine();
        }

        writer2.close();
    }

    public static void simpleRead() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Haris\\Desktop\\haris.txt"));
        System.out.println(reader.readLine());
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        // Koristeci append, nece nam obrisati tekst stari kad opet otvorimo file!
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Haris\\Desktop\\haris.txt", true));
        writer.write("Hello People!\n");


        String[] data = {"Apple", "Banana"};
        ArrayFileWrite(data);

        writer.close();




    }




}
