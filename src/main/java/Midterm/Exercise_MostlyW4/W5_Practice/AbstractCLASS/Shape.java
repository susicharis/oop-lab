package Midterm.Exercise_MostlyW4.W5_Practice.AbstractCLASS;

abstract class Shape {
    String color;
    double borderThickness;

    public Shape(String color, double borderThickness) {
        this.color = color;
        this.borderThickness = borderThickness;
    }

    abstract double calculateArea();

    public void printArea() {
        System.out.println("Area: " + calculateArea());
    }



}

class Circle extends Shape {
    double radius;

    public Circle(String color, double borderThickness, double radius) {
        super(color,borderThickness);
        this.radius = radius;
    }

    public double calculateArea() {
        double area = 3.14 * (radius * radius);
        return area;
    }



}

class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(String color, double borderThickness, double width, double height) {
        super(color,borderThickness);
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        double area = width * height;
        return area;
    }


}

class RealestMain {
    public static void main(String[] args) {
        Circle firstArea = new Circle("Red",10,5);
        Rectangle secondArea = new Rectangle("Blue",20,10,4);

        System.out.println(firstArea.calculateArea());
        System.out.println(secondArea.calculateArea());

        System.out.println("Print metoda u abstract: \n");

        firstArea.printArea();
        secondArea.printArea();


    }
}
