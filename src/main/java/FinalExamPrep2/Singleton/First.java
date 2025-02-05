package FinalExamPrep2.Singleton;

class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if(instance == null) {
            instance = new Logger();
        } return instance;
    }


}

class Mejnoo {
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        System.out.println(log1 == log2);
    }
}