package Week10Lecture;
import java.util.Scanner;
// student numbers start with the string "01" which is followed by seven numerical digits from 0 to 9


class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Give student number: ");
        String num = reader.nextLine();

        if (num.matches("01[0-9]{7}")) {
            System.out.println("The form is valid!");
        } else {
            System.out.println("The form is not valid!");
        }

        String string = "001";
        if(string.matches("00|111|0000")) {
            System.out.println("The string was matched by some of the alternatives");
        } else {
            System.out.println("The string was not matched by any alternatives");
        }


        System.out.println("Write a form of the verb to look: ");
        String word = reader.nextLine();

        if(word.matches("look(|s|ed|ing|er)")) {
            System.out.println("Well Done!");
        } else
            System.out.println("Check again the form!");



        // Repetitions
        String secondString = "trololololololo";
        // has to start with "trolo", and "lo" can happen 0/more times
        if(secondString.matches("trolo(lo)*")) {
            System.out.println("Right form!");
        } else
            System.out.println("Not good form!");

        String thirdString = "trolo";
        if(thirdString.matches("trolo(lo)*")) {
            System.out.println("GOOD!");
        } else
            System.out.println("NOT GOOD!");

        String fourthString = "trololololo";
        if(fourthString.matches("trolo(lo)+")) {
            System.out.println("GOODJOBMAN!");
        } else
            System.out.println("YOU CAN DO BETTER!");

        String fifthString = "trolololo";
        if(fifthString.matches("trolo(lo)?")) {
            System.out.println("YES MAN!");
        } else
            System.out.println("HOW NOT?");


        String sixString = "1010";
        if(sixString.matches("(10){2}")) {
            System.out.println("GOOD");
        } else
            System.out.println("DOESNT PONAVLJATI");
        String sixString2 = "10";
        if(sixString2.matches("10{1}")) {
            System.out.println("True!");
        } else {
            System.out.println("False!");
        }



        String sevenString = "2311";
        if(sevenString.matches("1{2,4}")) {
            System.out.println("True");
        } else
            System.out.println("False");



        String string8 = "1111111111";
        String string8v2 = "1";

        if (string8.matches("1{2,}")) {
            System.out.println("true");
        } else
            System.out.println("false");

        if (string8v2.matches("1{2,}")) {
            System.out.println("true");
        } else
            System.out.println("false");




        // One regular expression
        String string87 = "5550555";
        String string8v21 = "111111";

        if (string87.matches("5{3}(1|0)*5{3}")) {
            System.out.println("true");
        } else
            System.out.println("false");

    }
}

