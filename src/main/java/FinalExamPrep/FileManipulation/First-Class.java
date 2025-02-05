package FinalExamPrep.FileManipulation;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

class Files {
    // Simple writing to Files
    public static void simpleWrite(String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Haris\\Desktop\\harke.txt"));

        writer.write(text);
        writer.close();
    }

    // Writing array of Strings/Words to files
    public static void arrayFileWrite(String[] data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Haris\\Desktop\\harke.txt",true));

        for (String row : data) {
            writer.write(row + "\n");
        }

        writer.close();
    }

    // Reading everything(every line) from Files
    public static void readFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Haris\\Desktop\\harke.txt"));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }

    public static void readWholeFileList() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Haris\\Desktop\\harke.txt"));
        List<String> lines = reader.lines().collect(Collectors.toList());

        for (String line : lines) {
            System.out.println(line);
        }

        reader.close();
    }

}


class Main {
    public static void main(String[] args) throws IOException{
        Files.simpleWrite("Hello Guys");

        String[] data = {"Haris","Susic","King","LebronJames","Sunshine"};
        Files.arrayFileWrite(data);

        Files.readFromFile();

        System.out.println();
        System.out.println("Collectors: \n");
        Files.readWholeFileList();

    }
}