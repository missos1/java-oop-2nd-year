// package Polymorphism2;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    /**
     * Default constructor with no parameter.
     */
    public Rectangle(){

    }

    /**
     * Constructor with 2 parameters.
     * 
     * @param width of the rectangle
     * @param length of the rectangle
     */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor with 3 parameters.
     * 
     * @param width of the rectangle
     * @param length of the rectangle
     * @param color of the rectangle
     */
    public Rectangle(double width, double length, String color,
    boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Gets the rectangle's area.
     * 
     * @return the area
     */
    public double getArea() {
        return width * length;
    }

    /**
     * Gets the rectangle's perimeter.
     * 
     * @return the perimeter
     */
    public double getPerimeter() {
        return (width + length) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle[width=" + width 
        + ",length=" + length + ",color=" + color
        +  ",filled=" + filled + "]";
    }
}

