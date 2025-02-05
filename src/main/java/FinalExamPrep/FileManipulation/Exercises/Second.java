package FinalExamPrep.FileManipulation.Exercises;

import java.io.*;

class FileAppender {
    public void appendDataToFile(String filename, String[] data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true));
            for(String row : data) {
                writer.write(row);
            }

            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void readFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }


    }
}

class FileMain01 {
    public static void main(String[] args) {
        FileAppender fileApp = new FileAppender();
        String[] data = {"Haris ","Susic ","2004 ","1.81cm ","78KG ","Pure Muscle "};
        String filename = "C:\\Users\\Haris\\Desktop\\harke.txt";
        fileApp.appendDataToFile(filename,data);
        fileApp.readFile(filename);
    }
}
