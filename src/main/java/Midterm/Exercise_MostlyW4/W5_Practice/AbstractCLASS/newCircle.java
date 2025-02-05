package Midterm.Exercise_MostlyW4.W5_Practice.AbstractCLASS;

public class newCircle implements InterfaceA {
    String color;
    double borderThickness;
    double radius;

    public newCircle(String color, double borderThickness, double radius) {
        this.color = color;
        this.borderThickness = borderThickness;
        this.radius = radius;
    }

    public double calculateArea() {
        return 3.14 * (radius * radius);
    }

    public void printArea() {
        System.out.println("Circle Area: " + calculateArea());
    }

    public void printOutRest() {
        System.out.println("Color: " + this.color + ", Border Thickness : " + this.borderThickness);
    }
}

class RectanglePls implements InterfaceA {
    String color;
    double borderThickness;
    double width;
    double height;

    public RectanglePls(String color, double borderThickness, double width, double height) {
        this.color = color;
        this.borderThickness = borderThickness;
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    public void printArea() {
        System.out.println("Rectangle Area: " + calculateArea());
    }

    public void printOutRest() {
        System.out.println("Color: " + this.color + ", Border Thickness: " + this.borderThickness);
    }
}

class Mainest {
    public static void main(String[] args) {
        newCircle firstCircle = new newCircle("Red",10,5);
        RectanglePls firstRectangle = new RectanglePls("Orange",20,15,4);

        firstCircle.printArea();
        firstRectangle.printArea();

        firstCircle.printOutRest();
        firstRectangle.printOutRest();
    }
}
interface InterfaceA {
    double calculateArea();
    void printArea();
    void printOutRest();
}
