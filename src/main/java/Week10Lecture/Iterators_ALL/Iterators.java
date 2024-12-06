package Week10Lecture.Iterators_ALL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

class IteratorExample {
    public static void main(String[] args) throws NoSuchElementException {
       ArrayList<String> fruitsList = new ArrayList<>();
       fruitsList.add("Apple");
       fruitsList.add("Pear");
       fruitsList.add("Peach");

       Iterator<String> firstIterator = fruitsList.iterator();
       while(firstIterator.hasNext()) {
           String allFruits = firstIterator.next();
           System.out.println(allFruits);
       }

       // NE RADI ZATO STO ARRAYS NE IMPLEMENTIRAJU ITERABLE INTERFACE
       //  int[] numbers = {1,2,3};
       //  Iterator<Integer> secondIterator = numbers.iterator();

        // ALI MOZEMO CASTATI ARRAY U ARRAYLIST
        int[] numbers = {1,2,3};
       ArrayList<Integer> numberList = new ArrayList<>();
       // mora iteracija (rucno unosenje) jer bi inace unijelo samo prvi element!
       for (int num : numbers) {
           numberList.add(num);
       }

       Iterator<Integer> secondIterator = numberList.iterator();
       while(secondIterator.hasNext()) {
           int iteratorNumbers = secondIterator.next();
           System.out.println(iteratorNumbers);
       }
    }
}