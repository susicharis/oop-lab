package Week10Lecture.Files_ALL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReading {
    public static void simpleRead() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Haris\\Desktop\\haris.txt"));

        System.out.println(reader.readLine());
        reader.close();
    }

    // jedan nacin readanje whole filea
    public static void readWholeFile() throws IOException {
        BufferedReader secondReader = new BufferedReader(new FileReader("C:\\Users\\Haris\\Desktop\\haris.txt"));
        String temporary;
        while ((temporary = secondReader.readLine()) != null) {
            System.out.println(temporary);
        }

        secondReader.close();
    }
    // Streams -> transform file lines into ArrayList
    public static void readWholeFileList() throws IOException {
        BufferedReader thirdReader = new BufferedReader(new FileReader("C:\\Users\\Haris\\Desktop\\haris.txt"));
        List<String> allLines = thirdReader.lines().collect(Collectors.toList());

        for (String allValues : allLines) {
            System.out.println(allValues);
        }

        thirdReader.close();
    }

    public static void main(String[] args) throws IOException {
        simpleRead();
        System.out.println();
        readWholeFile();
        System.out.println();
        readWholeFileList();
    }
}
