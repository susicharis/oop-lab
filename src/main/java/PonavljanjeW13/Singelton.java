package PonavljanjeW13;

class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }


    public void log(String message) {
        System.out.println("log message");
    }

    public void logInfo(String message) {
        System.out.println("log info message");
    }
}

class Main {
    public static void main(String[] args) {
        Logger first = Logger.getInstance();
        Logger second = Logger.getInstance();

        System.out.println(first == second);
    }
}

