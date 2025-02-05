package FinalExamPrep.FileManipulation.Exercises;
// C:\Users\Haris\Desktop\harke.txt

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class SimpleFile {

    public void writeMessageToFile(String filename,String message) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(message);

        writer.close();
    }

    public void readMessageFromFile(String filename) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line;
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}

class FileMain {
    public static void main(String[] args) throws IOException{
        String filename = "C:\\Users\\Haris\\Desktop\\harke.txt";
        SimpleFile file = new SimpleFile();
        file.writeMessageToFile(filename, "I am the strongest in my faculty!");
        file.readMessageFromFile(filename);
    }
}