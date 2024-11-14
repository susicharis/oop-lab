package W5_Practice.AbstractCLASS;

public class FromInterfaceToAbstract implements newInterface {
    private int number1;
    private int number2;


    public FromInterfaceToAbstract(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;

    }

    public int calculate() {
        int number3 = number1+number2;
        return number3;
    }

}

class SecondClass implements newInterface {
    private int number1;
    private int number2;

    public SecondClass(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public int calculate() {
        int number3 = number1 + number2;
        return number3;
    }
}


interface newInterface {
    public int calculate();
}

class MainSecond {
    public static void main(String[] args) {
        FromInterfaceToAbstract firstCalc = new FromInterfaceToAbstract(10,20);
        System.out.println("The calculated number is: "+ firstCalc.calculate());

        SecondClass secondCalc = new SecondClass(50,100);
        System.out.println("The calculated number is: " + secondCalc.calculate());
    }
}
