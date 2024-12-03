package W5_Practice;
import java.util.ArrayList;

public class Printer {
    public void printOut(Readable methodInterface) {
        System.out.println(methodInterface.read());
    }

    public void printOut2(Readable method2Interface){

    }

    public static void main(String[] args) {
        myDate newDate = new myDate(30,8,2004);
        Person newPerson = new Person("Haris",28, newDate);
        SMS2 newSMS = new SMS2("Tarik","Topic je najjace prezime");

        Printer printOutObject = new Printer();
        printOutObject.printOut(newPerson);
        printOutObject.printOut(newSMS);
    }
}




