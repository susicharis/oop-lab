package Week11Lecture;

class ExceptionsPls {
    public static void main(String[] args) {
        // int number = Integer.parseInt("MyInt");
        // Ocekuje parametar tipa - String (koji je zapravo BROJ) koji ce konvertovati u INT
        // Ovdje saljemo TEKST umjesto String Broja -> NumberFormatException

        try {
            int number = Integer.parseInt("myInt");
            System.out.println("This will not be written to the console");
        } catch(NumberFormatException e) {
            System.out.println("Unable to cast!");
        }
        // Sad nece izbaciti Exception, nego ce vratiti samo sout - Unable to cast!
        // WHICH MEANS IT DOESNT CAUSE THE PROGRAM TO CRASH !!
        // IF THE EXCEPTION IS NOT THROWN, CATCH BLOCK WILL NEVER EXECUTE

        try {
            int number = Integer.parseInt("Hello");
        } catch (Exception e) {
            System.out.println("Fuck no this doesnt work..");
        }






    }
}