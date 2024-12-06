package Week10Lecture.Files_ALL;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

class ArrayWrite {
    public static void writeArray(String[] methodData) throws IOException {
        BufferedWriter writeAgain = new BufferedWriter(new FileWriter("C:\\Users\\Haris\\Desktop\\haris2.txt"));

        for(String allText : methodData) {
            writeAgain.write(allText);
        }

        writeAgain.close();
    }
}

class WriteInFile {
    public static void simpleWrite(String text) throws IOException {
        BufferedWriter writeOut = new BufferedWriter(new FileWriter("C:\\Users\\Haris\\Desktop\\haris.txt", true));
        writeOut.write(text);
        writeOut.close();
    }

    //Reading
    public static void readValues() throws IOException {
        BufferedReader readOut = new BufferedReader(new FileReader("C:\\Users\\Haris\\Desktop\\haris.txt"));
        System.out.println(readOut.readLine());
        readOut.close();

    }

    //Reading ALL Values from the File
    public static void readAllValues() throws IOException {
        BufferedReader readAll = new BufferedReader(new FileReader("C:\\Users\\Haris\\Desktop\\haris.txt"));
        String temporary;
        while((temporary = readAll.readLine()) != null) {
            System.out.println(temporary);
        }

        readAll.close();
    }

    // Stream -> Transform file lines into ArrayList
    public static void fromLinesToArray() throws IOException {
        BufferedReader transformAndRead = new BufferedReader(new FileReader("C:\\Users\\Haris\\Desktop\\haris.txt"));
        List<String> allLines = transformAndRead.lines().collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        simpleWrite("Haris is king! \n");
        simpleWrite("Haris is still king! \n");
        simpleWrite("Now KennyS is best AWPER! \n");



        String[] mainData = {"KennyS \n","Monesy \n","Niko \n"};
        ArrayWrite.writeArray(mainData);

        readValues();
        System.out.println();
        System.out.println();
        System.out.println("Reading all Values : \n");
        readAllValues();
    }
}

