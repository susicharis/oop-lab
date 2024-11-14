package W5_Practice.AbstractCLASS;

abstract class ToAbstract {
    int number1;
    int number2;

    public ToAbstract(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    abstract int calculatePls();
}


class FromToAbstract extends ToAbstract {
    public FromToAbstract(int number1, int number2) {
        super(number1,number2);
    }

    public int calculatePls() {
        return number1 + number2;
    }
}

class abstractMain {
    public static void main(String[] args) {
        FromToAbstract firstCalculation = new FromToAbstract(10,20);
        System.out.println(firstCalculation.calculatePls());
    }
}
