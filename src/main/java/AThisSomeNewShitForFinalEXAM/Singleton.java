package AThisSomeNewShitForFinalEXAM;

class Singleton {
    private static Singleton instance;

    private Singleton() {

    }

    private static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }


}