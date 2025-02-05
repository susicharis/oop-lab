package Quiz4Prep.W10.W10;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

class Files {

    public static void simpleWrite(String text) throws IOException {
        BufferedWriter firstWriter = new BufferedWriter(new FileWriter("C:\\Users\\Haris\\Desktop\\kviz.txt"));
        firstWriter.write(text);
        firstWriter.close();
        }

    public static void arrayFileWrite(String[] data) throws IOException {
        BufferedWriter secondWriter = new BufferedWriter(new FileWriter("C:\\Users\\Haris\\Desktop\\kviz.txt",true));
        for (String row : data) {
            secondWriter.write(row);
        }

        secondWriter.close();
    }

    public static void simpleRead() throws IOException {
        BufferedReader firstReader = new BufferedReader(new FileReader("C:\\Users\\Haris\\Desktop\\kviz.txt"));
        System.out.println(firstReader.readLine());
        firstReader.close();
    }

    public static void readAllLines(String[] data) throws IOException {
        BufferedReader secondReader = new BufferedReader(new FileReader("C:\\Users\\Haris\\Desktop\\kviz.txt"));
        for (String rows : data) {
            System.out.println(rows);
        }
        secondReader.close();
    }

    public static void usingStreams() throws IOException {
        BufferedReader thirdReader = new BufferedReader(new FileReader("C:\\Users\\Haris\\Desktop\\kviz.txt"));
        List<String> lines = thirdReader.lines().collect(Collectors.toList()); // lines() - vraca Stream<String>, gdje je svaki red iz filea pojedinacan element
        System.out.println(lines); // vraca sa zagradama zato sto koristi toString metodu klase ArrayList - formatira String u Object

        for (String line : lines) {
            System.out.println(line);
        }

        thirdReader.close();
    }

    public static void newInput(String[] data2) throws IOException {
        BufferedWriter fileWriterNeki = new BufferedWriter(new FileWriter("C:\\Users\\Haris\\Desktop\\kviz.txt",true));
        for(String rows : data2) {
            fileWriterNeki.write(rows);
        }
    }

    public static void readWholeFilePls() throws IOException {
        BufferedReader fourthReader = new BufferedReader(new FileReader("C:\\Users\\Haris\\Desktop\\kviz.txt"));
        String temporary;

        while ((temporary = fourthReader.readLine()) != null) {
            System.out.println(temporary);
        }
    }




}


class MainLol {
    public static void main(String[] args) throws IOException {
        Files.simpleWrite("Harke");
        String[] data = {"Haris","Susic","je","king!"};
        String[] data2 = {"Zero","Sta ti je"};
        Files.arrayFileWrite(data);

        Files.simpleRead();
        System.out.println();
        Files.readAllLines(data);

        System.out.println();
        Files.usingStreams();

        Files.newInput(data2);

        System.out.println();
        Files.readWholeFilePls();

    }
}