package Midterm.Exercise_MostlyW4.QuizzPriprema;

class Storage<T> {
    T items;

    public Storage(T items) {
        this.items = items;
    }

    public T getItems() {
        return items;
    }
    public void setItems(T items) {
        this.items = items;
    }

    public String printDetails() {
        return "Dobio si item! Polizi lizu!";
    }
}

class StorageTester {
    public static void main(String[] args) {

        Storage<String> stringStorage = new Storage<>("Hello, World!");
        Storage<Integer> integerStorage = new Storage<>(123);
        Storage<Double> doubleStorage = new Storage<>(45.67);


        System.out.println(stringStorage.printDetails());  // Prints details for String
        System.out.println(integerStorage.printDetails()); // Prints details for Integer
        System.out.println(doubleStorage.printDetails());  // Prints details for Double
    }
}