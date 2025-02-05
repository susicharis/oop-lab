package RevisionLab13.Singleton2;

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
        System.out.println("Log: " + message);
    }
    public void logInfo(String message) {
        System.out.println("Log info: " + message);
    }
    public void logWarning(String message) {
        System.out.println("Log Warning: " + message);
    }
    public void logError(String message) {
        System.out.println("Log Error: " + message);
    }

}

class Main01 {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("This is log message.");
        logger.logInfo("This is log info message.");
    }
}

