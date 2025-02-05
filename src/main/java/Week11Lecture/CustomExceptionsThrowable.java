package Week11Lecture;

class IfAgeLessThanZeroException extends Exception {
    public IfAgeLessThanZeroException(String message) {
        super(message);  // Passing message to the Exception constructor
    }

    public IfAgeLessThanZeroException(Throwable cause) {
        super(cause);  // Passing cause to the Exception constructor
    }

    public IfAgeLessThanZeroException(String message, Throwable cause) {
        super(message, cause);  // Passing both message and cause to the Exception constructor
    }
}

class CustomExceptions2 {

    public static void main(String[] args) {
        try {
            // You can call any of these methods to test
            validateAge(-1);
            //validateAgeThrowable(-1);
            //validateAgeThrowableMessage(-1);
        } catch (IfAgeLessThanZeroException e) {
            // Catching the custom exception and printing the message and cause
            System.out.println("Caught exception: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Cause: " + e.getCause().getMessage());
            }
        }
    }

    // Simple validation method that throws IfAgeLessThanZeroException with a message
    public static void validateAge(int age) throws IfAgeLessThanZeroException {
        if(age < 0) {
            throw new IfAgeLessThanZeroException("Age cannot be negative!");
        }
    }

    // Method that throws IfAgeLessThanZeroException with a RuntimeException as a cause
    public static void validateAgeThrowable(int age) throws IfAgeLessThanZeroException {
        if(age < 0) {
            throw new IfAgeLessThanZeroException(new RuntimeException("Negative age is not allowed!"));
        }
    }

    // Method that throws IfAgeLessThanZeroException with both message and RuntimeException as a cause
    public static void validateAgeThrowableMessage(int age) throws IfAgeLessThanZeroException {
        if(age < 0) {
            throw new IfAgeLessThanZeroException("Problem with age again", new RuntimeException("This is a runtime exception!"));
        }
    }
}
