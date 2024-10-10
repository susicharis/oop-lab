package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // W1 Lecture Task
        /*
        String leave;

        while(true) {
            System.out.println("Do you wanna -do meth- or -exit- ?: ");
            leave = sc.nextLine();


            if (leave.equals("Exit")) {
                System.out.println("Goodbye!");
                break;
            }

            if (leave.equals("do meth")) {
                System.out.println("Enter first number: ");
                int n1 = Integer.parseInt(sc.nextLine());

                System.out.println("Enter second number: ");
                int n2 = Integer.parseInt(sc.nextLine());

                System.out.println("Add or Subtract? ");
                String operator = sc.nextLine();


                if (operator.equals("Add")) {
                    int rezultat1 = n1 + n2;
                    System.out.println("Adding : " + rezultat1);
                } else if (operator.equals("Subtract")) {
                    int rezultat2 = n1 - n2;
                    System.out.println("Subtracting : " + rezultat2);
                }
            }

        } sc.close();
        */


        // Lab Week 1 ---------------------------------------------->

        // Task 1
        /*
         System.out.println("My name is Haris Susic");
         */

        // Task 2

        /*
        System.out.println("Hello World!");
        System.out.print("(And all the people of the world)");
        */

        // Task 3

        /*
        int sekundi_u_minuti = 60;
        int minuti_u_satu = 60;
        int sati_u_danu = 24;
        int dana_u_godini = 365;

        int sekundi_u_godini = sekundi_u_minuti * minuti_u_satu * sati_u_danu * dana_u_godini;
        System.out.println("Broj sekundi u jednoj godini je: " + sekundi_u_godini);

         */

        // Task 4
    /*
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int n1 = Integer.parseInt(sc2.nextLine());

        System.out.println("Enter second number: ");
        int n2 = Integer.parseInt(sc2.nextLine());

        int sum = n1 + n2;
        System.out.println("Their sum is: " + sum);

     */

        // Task 5
     /*
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter a number: ");

        int n1 = Integer.parseInt(sc2.nextLine());

        if (n1 > 0) {
            System.out.println("The number is positive!");
        } else {
            System.out.println("The number is negative!");
        }

      */

        // Task 6

        /*
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int n1 = Integer.parseInt(sc2.nextLine());

        System.out.println("Enter second number: ");
        int n2 = Integer.parseInt(sc2.nextLine());

        if (n1 > n2) {
            System.out.println("Greater number is: " + n1);
        } else {
            System.out.println("Greater number is: " + n2);
        }


         */


        // Lab WEEK 2 --------------------------------------------->

        // Task 1
/*
        Scanner sc = new Scanner(System.in);
        String real_password = "harke123";
        String password;

        do {
            System.out.println("Enter your password: ");
            password = sc.nextLine();

            if (!password.equals(real_password)) {
                System.out.println("Wrong password!");
            }
        } while (!password.equals(real_password));

        System.out.println("You logged in! The secret message is : giganiggachad. ");
*/

        // Task 2
/*
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int n1 = Integer.parseInt(sc.nextLine());

        System.out.println("Enter second number: ");
        int n2 = Integer.parseInt(sc.nextLine());

        System.out.println("Enter third number: ");
        int n3 = Integer.parseInt(sc.nextLine());

        int sum = n1 + n2 + n3;
        System.out.println("The sum is: " + sum);

        sc.close();
*/

        // Task 3
/*
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int numbers;

        while(true) {
            System.out.print("Enter a number(0 to stop): ");
            numbers = Integer.parseInt(sc.nextLine());

            if (numbers == 0) {
                break;
            }

            sum += numbers;
        }

        System.out.println("Sum: " + sum);


*/

        // Task 4

/*
        Scanner sc = new Scanner(System.in);
        int firstNumber;
        int lastNumber;

        System.out.println("Enter first number: ");
        firstNumber = Integer.parseInt(sc.nextLine());

        System.out.println("Enter second number: ");
        lastNumber = Integer.parseInt(sc.nextLine());

        if (firstNumber > lastNumber) {

            int currentNumber = firstNumber;
            while(currentNumber >= lastNumber) {
                System.out.println(currentNumber);
                currentNumber--;
            }

        } else {
            int currentNumber = firstNumber;

            while (currentNumber <= lastNumber) {
                System.out.println(currentNumber);
                currentNumber++;
            }
        }


 */


        // Task 5


/*
                Scanner sc = new Scanner(System.in);
                int sum = 0;

                System.out.println("Enter the value of n: ");
                int n = Integer.parseInt(sc.nextLine());


                for (int i = 20; i <= n; i++) {
                    int power = (int) Math.pow(2, i);
                    sum += power;
                }


                System.out.println("The sum of powers of 2 from 20 to 2^" + n + " is: " + sum);



 */

        // Task 6
        /*
            public static void printText() {
                System.out.println("In the beginning there were the swamp, the hoe and Java.");
            }

                Scanner sc = new Scanner(System.in);


                System.out.println("How many times do you want to print the text?");
                int times = Integer.parseInt(sc.nextLine());


                for (int i = 0; i < times; i++) {
                printText();
            }


         */
        // Task 7
/*
        public static void drawStarsPyramid ( int rows){
            for (int i = 1; i <= rows; i++) {

                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }

                System.out.println();
            }


        }

        drawStarsPyramid(5);

 */

        // Task 8

        /*


        public static void drawInvertedPyramid(int rows) {
            for (int i = rows; i >= 1; i--) {

                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }

                System.out.println();
            }
        }

        public static void main(String[] args) {

            drawInvertedPyramid(10);
        }

         */

        // Task 9
/*
        public static void drawNumbersPyramid(int rows) {
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }

            public static void main(String[] args) {

                drawNumbersPyramid(5);
            }

 */

    }
}



