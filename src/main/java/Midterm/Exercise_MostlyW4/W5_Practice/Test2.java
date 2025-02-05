package Midterm.Exercise_MostlyW4.W5_Practice;
import java.util.ArrayList;

public class Test2 implements Readable {
    private ArrayList<Readable> readables;

    public Test2() {
        this.readables = new ArrayList<Readable>();
    }

    public void addPlease(Readable addToReadables) {
        this.readables.add(addToReadables);
    }

    public String toString() {
        String read = "";
        for(Readable formatting : readables) {
           read += formatting + "\n";
        } return read;
    }

    public String read() {
        return "Why would you call me..";
    }

    public String readThis() {
        return "Pls dont call me..";
    }





    public static void main(String[] args) {
        Test2 joeList = new Test2();
        joeList.addPlease(new SMS2("Sara","Im the prettiest"));
        joeList.addPlease(new SMS2("Sarah","Ja sam jer imam -h-"));

        System.out.println(joeList);
        System.out.println(joeList.read());


    }

}
