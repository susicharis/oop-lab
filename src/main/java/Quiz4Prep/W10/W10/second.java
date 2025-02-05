package Quiz4Prep.W10.W10;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class NeparniBrojevi implements Iterator<Integer> {

    private int elements[];
    private int currentIndex = 0;

    public NeparniBrojevi(int elements[]) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex < elements.length && elements[currentIndex] % 2 == 0) {
            currentIndex++;
        } return currentIndex < elements.length;
    }

    @Override
    public Integer next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        } else
            return this.elements[currentIndex++];
    }


    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9};

        NeparniBrojevi iterator = new NeparniBrojevi(numbers);
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}