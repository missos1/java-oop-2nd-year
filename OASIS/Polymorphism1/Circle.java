// package Polymorphism1;

public class Circle extends Shape {
    protected double radius;

    /**
     * Default constructor with no parameter.
     */
    public Circle() {

    }

    /**
     * Constructor with radius parameter.
     * 
     * @param radius of the circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor with 3 parameters.
     * 
     * @param radius of the circle
     * @param color of the circle
     * @param filled fill the circle or not
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius
        + ",color=" + color + ",filled=" + filled + "]";
    }
}
