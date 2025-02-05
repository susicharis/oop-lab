package FinalExamPrep.Iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> champs = new ArrayList<>();
        champs.add("Islam");
        champs.add("McGregor");
        champs.add("Charles");

        Iterator<String> iterator = champs.iterator();
        while(iterator.hasNext()) {
            String allChamps = iterator.next();
            System.out.println(allChamps);
        }


        // Custom Iterator
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        OddNumbersIterator oddIterator = new OddNumbersIterator(numbers);
        while(oddIterator.hasNext()) {
            System.out.println(oddIterator.next());
        }
    }
}


class OddNumbersIterator implements Iterator<Integer> {
    private int[] elements;
    private int currentIndex = 0;

    public OddNumbersIterator(int[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex < this.elements.length && elements[currentIndex] % 2 == 0) {
            currentIndex++;
        }
        return currentIndex < elements.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        // povecava index , ne broj
        return elements[currentIndex++];
    }
}
