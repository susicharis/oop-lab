package Week10LAB.AdditionalPractice.Iterators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

class Events {
    public void generateEventsFile(String filename, int numberOfRecords) {
        Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] eventTypes = {"Login","Logout","Purchase","ViewPage","Error"};
        int userID = random.nextInt(1000);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for(int i = 0; i < numberOfRecords; i++) {

                Date currentDate = new Date();

                int randomDays = random.nextInt(30);
                int randomHours = random.nextInt(24);
                int randomMinutes = random.nextInt(60);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);

                calendar.add(Calendar.DAY_OF_YEAR, - randomDays);
                calendar.add(Calendar.HOUR_OF_DAY, - randomHours);
                calendar.add(Calendar.MINUTE, - randomMinutes);

                Date randomDate = new Date();
                randomDate = calendar.getTime();

                String timestamp = dateFormat.format(dateFormat);

                String eventType = eventTypes[random.nextInt(eventTypes.length)];

                String event = "Timestamp: " + timestamp + " | Event Type: " + eventType + " | User ID: " + userID;
                writer.write(event);
                writer.newLine();

            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}