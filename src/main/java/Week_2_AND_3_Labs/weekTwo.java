package Week_2_AND_3_Labs;
// Week Two Lab Tasks
public class weekTwo {
    public static void main(String[] args) {


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

                System.out.println(); // I am king
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
