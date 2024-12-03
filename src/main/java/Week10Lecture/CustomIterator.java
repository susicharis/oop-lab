package Week10Lecture;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Custom collection that holds positive integers, and we want to create an iterator that skips over even numbers during iteration.

/*

 */

class OddNumbersIterator implements Iterator<Integer> {
    private int[] elements;
    private int currentIndex = 0;

    public OddNumbersIterator(int[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        // dokle god je currentIndex unutar granica niza(elements.length) i element je PARAN, povecaj za 1
        // (kako bi dobili NEPARAN BROJ), tj preskace sve PARNE BROJEVE
        while (currentIndex < elements.length && elements[currentIndex] % 2 == 0) {
            currentIndex++;
        }

        return currentIndex < elements.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return elements[currentIndex++];
        // vrati trenutni element na poziciji currentIndex,i povecaj currentIndex za 1 nakon sto je element vracen
    }
}

class MainOfMains {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        OddNumbersIterator firstIterator = new OddNumbersIterator(numbers);
        while (firstIterator.hasNext()) {
            System.out.println(firstIterator.next());
        }
    }
}
