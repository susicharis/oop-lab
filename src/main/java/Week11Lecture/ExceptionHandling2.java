package Week11Lecture;

public class ExceptionHandling2 {
    public static int finallyExample(){
        try {
            return 1;
        } catch (Exception e){
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(finallyExample());
    }
}
