package FinalExamPrep.Iterators.LabPractices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Event {
    String name;
    String location;
    String time;

    public Event(String name, String location, String time) {
        this.name = name;
        this.location = location;
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Location: " + this.location + ", Time: " + this.time;
    }
}

class EveningEventIterator implements Iterator<Event> {
    List<Event> eventsList;
    String afterThisTime = "18:00";
    int currentIndex = 0;

    public EveningEventIterator(List<Event> eventsList) {
        this.eventsList = eventsList;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex < eventsList.size()) {
            if(eventsList.get(currentIndex).getTime().compareTo(afterThisTime) > 0) {       // vraca "> 0" ako je poslije 18:00, "0" ako je == 18:00, "< 0" ako je prije 18:00
                return true;
            } currentIndex++;
        } return false;
    }

    @Override
    public Event next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        } return eventsList.get(currentIndex++);
    }

}

class Main10 {
    public static void main(String[] args) {
        List<Event> playlist = new ArrayList<>();
        playlist.add(new Event("Event 1","NYC","18:05"));
        playlist.add(new Event("Event 2", "LA","17:59"));
        playlist.add(new Event("Event 3","NYC","18:03"));

        EveningEventIterator iterator = new EveningEventIterator(playlist);

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}