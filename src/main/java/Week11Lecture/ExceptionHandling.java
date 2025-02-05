package Week11Lecture;

class ExceptionHandling {
    /*
        When the exception is not handled right immediately where it can cause an error the exception is passed to the method
         that called the method that throws an exception
        We refer to this as an call stack, and the exception goes up in the call stack until it is eventually handled by the
         try-catch block
        So now, we will extract the logic for parsing an string to an int into another method,
         but the exception handling will not take place into that method, rather we will handle the exception
         in the caller method as shown in the following example
         */

    public static int getParsedInt(String stringNumber) {
        int numberParsed = Integer.parseInt(stringNumber);
        return numberParsed;
    }

    // Multi-Catch (Vise catchova u jednom parametru - da ne moramo koristiti vise catchova
    public static int multiCatch(String stringNumber) {
        try {
            int numberParsed = getParsedInt(stringNumber);
            return numberParsed;
        } catch (NumberFormatException  | NullPointerException e) {
            System.out.println("Damn man, more exceptions and still doesnt run..");
        }
        return 0;
    }

    public static void main(String[] args) {
        try {
            int numberParsed = getParsedInt("myInt");
        } catch (NumberFormatException e) {
            System.out.println("Unable to cast..");
        }

        multiCatch("12hi");

        // finally block - gets executed no matter what
        System.out.println("\n Finally block : ");
        try {
            int numberParsed = getParsedInt("myInt");
        } catch (NumberFormatException e) {
            System.out.println("Unable to cast string to integer...");
        } catch (NullPointerException e) {
            System.out.println("NullPointer has been thrown..");
        } finally {
            System.out.println("Im always executed!");
        }



        try {
            int numberPrased = getParsedInt("myInt");
            System.out.println("This will not be written cause of exception - it skips to catch");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Unable to cast to integer!");
        } finally {
            System.out.println("Still here executing (finally) even with return! ");
        }
    }
}
