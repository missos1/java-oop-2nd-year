// package Polymorphism2;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    /**
     * Default constructor with no parameter.
     */
    public Shape(){

    }

    /**
     * Constructor with 2 parameters.
     * 
     * @param color desired color
     * @param filled fill shape or not
     */
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get the area of the desired shape.
     * 
     * @return the shape's area
     */
    public abstract double getArea();

    /**
     * Get the perimeter of the desired shape.
     * 
     * @return the shape's perimeter
     */
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape[color=" + color
        + ",filled=" + filled + "]";
    }
}
