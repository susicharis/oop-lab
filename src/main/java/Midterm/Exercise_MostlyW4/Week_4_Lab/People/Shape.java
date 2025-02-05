package Midterm.Exercise_MostlyW4.Week_4_Lab.People;


enum FillType {
    FILLED,
    NOT_FILLED
}

public class Shape {
    private String color;
    private FillType fillType;

    public Shape(String color, FillType fillType) {
        this.color = color;
        this.fillType = fillType;
    }

    public void displayInfo() {
        System.out.println("Color: " + color);
        if (fillType == FillType.FILLED) {
            System.out.println("It is filled.");
        } else {
            System.out.println("It is not filled.");
        }
    }
}

class Circle extends Shape {
    private double radius;

        public Circle(String color, FillType fillType, double radius) {
            super(color, fillType);
            this.radius = radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double calculateCircumference(double PI, double r) {
            return 2 * PI * r;
        }

        public double calculateCircumference(double r) {
            return 2 * Math.PI * r;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Shape: Circle");
            System.out.println("Radius: " + radius);
            System.out.println("Area: " + getArea());
            System.out.println("Circumference (using constant PI): " + calculateCircumference(radius));
        }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, FillType fillType, double width, double height) {
        super(color, fillType);
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Shape: Rectangle");
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + getArea());
    }
}
