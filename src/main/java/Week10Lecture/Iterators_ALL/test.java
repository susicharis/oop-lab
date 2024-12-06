package Week10Lecture.Iterators_ALL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
Suppose you have a custom collection that holds only positive integers,
and you want to create an iterator that skips over even numbers during iteration.
You can achieve this with a custom iterator.
 */

class OddNumbersIterators implements Iterator<Integer> {
    private int[] elements;
    private int currentIndex = 0;

    public OddNumbersIterators(int[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < elements.length && elements[currentIndex] % 2 == 0) {
            currentIndex++;
        }
        // ovaj return je bukvalno kao default hasNext, osigurava da ne prelazi granice niza
        return currentIndex < elements.length;
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else
            return elements[currentIndex++];
    }
}



class Test {
    public static void main(String[] args) throws NoSuchElementException {
        ArrayList<String> values = new ArrayList<>();
        values.add("100BAM");
        values.add("200BAM");
        values.add("300BAM");

        Iterator<String> valuesIterator = values.iterator();
        /*
        System.out.println(valuesIterator);
        - kao prvo, uzima samo jednu vrijednost
        - kao drugo, ispisati ce instancu tog objekta(njegovu adresu), nece vrijednost
         */

        while(valuesIterator.hasNext()) {
            System.out.println(valuesIterator.next());

        }

        System.out.println();
        System.out.println();

        int[] numbers = {1,2,3,4,5,6,7,8,9};
        OddNumbersIterators freshIterator = new OddNumbersIterators(numbers);

        while(freshIterator.hasNext()) {
            System.out.println(freshIterator.next());
        }

    }
}
