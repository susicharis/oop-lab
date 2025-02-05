package DesignPatterns_W13_Class.Singleton;
// https://chatgpt.com/share/67788c54-321c-800d-9d4e-d96c690f8ac5

class Logger2 {
    private static Logger2 instance;

    private Logger2() {
    }

    public static Logger2 getInstance() {
        if (instance == null) {
            instance = new Logger2();
        }

        return instance;
    }

    public void readOut(String message) {
        System.out.println(message);
    }
}

class Main01 {
    public static void main(String[] args) {
        Logger2 firstLogger = Logger2.getInstance();
        firstLogger.readOut("Hello");

        Logger2 secondLogger = Logger2.getInstance();
        secondLogger.readOut("Hello again!");

        System.out.println(firstLogger == secondLogger);
    }
}