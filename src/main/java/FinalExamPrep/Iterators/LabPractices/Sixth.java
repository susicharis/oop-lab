package FinalExamPrep.Iterators.LabPractices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Project {
    String name;
    String category;
    double budget;
    int deadlineInDays;

    public Project(String name, String category, double budget, int deadlineInDays) {
        this.name = name;
        this.category = category;
        this.budget = budget;
        this.deadlineInDays = deadlineInDays;
    }

    public String getCategory() {
        return this.category;
    }
    public double getBudget() {
        return this.budget;
    }
    public int getDeadlineInDays() {
        return this.deadlineInDays;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Category: " + this.category + ", Budget: " + this.budget + ", Deadline in days: " + this.deadlineInDays;
    }
}

class ComplexProjectIterator implements Iterator<Project> {
    List<Project> projects;
    String targetCategory;
    double minBudget;
    int maxDeadline;
    int currentIndex = 0;

    public ComplexProjectIterator(List<Project> projects, String targetCategory, double minBudget, int maxDeadline) {
        this.projects = projects;
        this.targetCategory = targetCategory;
        this.minBudget = minBudget;
        this.maxDeadline = maxDeadline;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex < projects.size()) {
            if(projects.get(currentIndex).getCategory().equals(targetCategory)) {
                if(projects.get(currentIndex).getBudget() >= minBudget) {
                    if(projects.get(currentIndex).getDeadlineInDays() <= maxDeadline) {
                        return true;
                    }
                }
            } currentIndex++;
        } return false;

    }

    @Override
    public Project next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        } return projects.get(currentIndex++);
    }
}

class Main011 {
    public static void main(String[] args) {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("AI Assistant","AI",20000,10));
        projects.add(new Project("Portfolio Website","Web Development",5000,15));
        projects.add(new Project("Mobile Game","Mobile Development",10000,5));
        projects.add(new Project("AI Chatbot", "AI",15000,20));

        ComplexProjectIterator iterator = new ComplexProjectIterator(projects,"AI",15000,15);
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
