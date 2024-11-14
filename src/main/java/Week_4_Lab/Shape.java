package Week_4_Lab;


enum FillType {
    FILLED,
    NOT_FILLED
}

public class Shape {
    private String color;
    private FillType filled;

    public Shape(String color, FillType filled) {
        this.color = color;
        this.filled = filled;
    }

    public void displayInfo() {
        System.out.println("Color: " + color);
        if (filled == FillType.FILLED) {
            System.out.println("It is filled.");
        } else {
            System.out.println("It is not filled.");
        }
    }

}



class Circle extends Shape {
    private double radius;

        public Circle(String color, FillType filled, double radius) {
            super(color,filled);
            this.radius = radius;
        }



        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double calculateCircumference() {
            return 2 * Math.PI * radius;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Radius: " + radius);
            System.out.println("Area: " + getArea());
            System.out.println("Circumference: " + calculateCircumference());

        }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, FillType filled, double width, double height) {
        super(color,filled);
        this.width = width;
        this.height = height;


    }
}