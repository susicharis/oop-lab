package FinalExamPrep.Iterators.LabPractices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Task {
    String description;
    String priority;
    String dueDate;

    public Task(String description,String priority, String dueDate) {
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return this.priority;
    }

    @Override
    public String toString() {
        return "Description: " + description + ", Priority: " + priority + ", Due Date: " + dueDate;
    }
}

class PriorityTaskIterator implements Iterator<Task> {
    List<Task> listOfTasks;
    String targetPriority;
    int currentIndex = 0;

    public PriorityTaskIterator(List<Task> listOfTasks,String targetPriority) {
        this.listOfTasks = listOfTasks;
        this.targetPriority = targetPriority;
    }


    @Override
    public boolean hasNext() {
        while(currentIndex < listOfTasks.size()) {
            if(listOfTasks.get(currentIndex).getPriority().equals(targetPriority)) {
                return true;
            } currentIndex++;
        } return false;
    }

    @Override
    public Task next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }return listOfTasks.get(currentIndex++);
    }
}

class Main09 {
    public static void main(String[] args) {
        List<Task> playlist = new ArrayList<>();
        playlist.add(new Task("Description 1","boobs","2026"));
        playlist.add(new Task("Description 2","boobs","End of 2025"));
        playlist.add(new Task("Description 3","ass","Mid of 2025"));

        PriorityTaskIterator iterator = new PriorityTaskIterator(playlist,"boobs");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}