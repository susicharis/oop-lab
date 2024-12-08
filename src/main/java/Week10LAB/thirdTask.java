package Week10LAB;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class Events {

    // Method to generate a file with random event records
    public void generateEventsFile(String filename, int numberOfRecords) {
        Random random = new Random();
        String[] eventTypes = {"Login", "Logout", "Purchase", "ViewPage", "Error"};
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> events = new ArrayList<>();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < numberOfRecords; i++) {

                long currentTime = System.currentTimeMillis() - random.nextInt(1000000000);
                Date randomDate = new Date(currentTime);
                String timestamp = dateFormat.format(randomDate);


                String eventType = eventTypes[random.nextInt(eventTypes.length)];


                int userId = random.nextInt(1000);


                String event = "Timestamp: " + timestamp + " | Event Type: " + eventType + " | User ID: " + userId;


                writer.write(event);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void printEventsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<String> readEventsFromFile(String filename) {
        ArrayList<String> events = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                events.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }

    public static void main(String[] args) {

        Events events = new Events();


        String filename = "events.txt";
        events.generateEventsFile(filename, 10);


        System.out.println("Printing events from the file:");
        events.printEventsFromFile(filename);


        ArrayList<String> eventRecords = events.readEventsFromFile(filename);
        System.out.println("\nReading events into an ArrayList:");
        for (String event : eventRecords) {
            System.out.println(event);
        }
    }
}
