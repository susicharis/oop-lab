package DesignPatterns_W13_Class.Singleton;

import java.util.Scanner;

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
        System.out.println(message);
    }
    public void logInfo(String message) {
        System.out.println(message);
    }
    public void logWarning(String message) {
        System.out.println(message);
    }
    public void logError(String message) {
        System.out.println(message);
    }
}

class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter level: ");
        int level = sc.nextInt();

        Logger instancePls = Logger.getInstance();
        if(level == 0) {
            instancePls.log("Level 0 : log!");
        } else if (level == 1) {
            instancePls.logInfo("Level 1 : Log info!");
        } else if (level == 2) {
            instancePls.logWarning("Level 2 : Log Warning!");
        } else {
            instancePls.logError("Last Level(3) : Log Error!");
        }




    }
}