/**
 * Week 6 Practice - Problem 2: Shape Area Calculator (Abstraction + Polymorphism)
 * Abstract class Shape with Circle, Rectangle, and Triangle subclasses.
 */
public class PROGRAM2 {

    static abstract class Shape {
        public abstract double calculateArea();
        public abstract String getShapeName();

        @Override
        public String toString() {
            return getShapeName() + " -> Area: " + String.format("%.2f", calculateArea());
        }
    }

    static class Circle extends Shape {
        private double radius;
        public Circle(double radius) { this.radius = radius; }
        @Override public double calculateArea() { return Math.PI * radius * radius; }
        @Override public String getShapeName() { return "Circle (r=" + radius + ")"; }
    }

    static class Rectangle extends Shape {
        private double length, width;
        public Rectangle(double length, double width) { this.length = length; this.width = width; }
        @Override public double calculateArea() { return length * width; }
        @Override public String getShapeName() { return "Rectangle (" + length + "x" + width + ")"; }
    }

    static class Triangle extends Shape {
        private double base, height;
        public Triangle(double base, double height) { this.base = base; this.height = height; }
        @Override public double calculateArea() { return 0.5 * base * height; }
        @Override public String getShapeName() { return "Triangle (b=" + base + ", h=" + height + ")"; }
    }

    public static void printAreaReport(Shape[] shapes) {
        System.out.println("--- Shape Area Report ---");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5), new Rectangle(10, 4), new Triangle(8, 6), new Circle(3.5)
        };
        printAreaReport(shapes);
    }
}
