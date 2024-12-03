package Week10Lecture;
import java.util.Iterator;
import java.util.NoSuchElementException;

class IteratorOddNumbers implements Iterator<Integer> {
    private int[] elements;
    private int currentIndex = 0;

    public IteratorOddNumbers(int[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
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




class Mainest {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        IteratorOddNumbers firstOne = new IteratorOddNumbers(numbers);

        while(firstOne.hasNext()) {
            System.out.println(firstOne.next());
        }

    }
}