// package Polymorphism2;

import java.awt.Graphics;
import java.awt.Color;


public abstract class Shape {
    protected String color;
    protected boolean filled;
    protected double dx;
    protected double dy;
    protected Color colorr;

    /**
     * Default constructor with no parameter.
     */
    public Shape(){

    }

    /**
     * Constructor with 4 parameters.
     * 
     * @param color desired color
     * @param filled fill shape or not
     */
    public Shape(String color, boolean filled, double dx, double dy) {
        this.color = color;
        this.filled = filled;
        this.dx = dx;
        this.dy = dy;
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

    /**
     * Updates movement of the shape.
     */
    public void move() {

    }

    /**
     * Draws the shape onto window
     * @param g the Graphics param of swing
     */
    public void draw(Graphics g) {

    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    @Override
    public abstract String toString();

    protected Color stringToColor(String color) {
        if (color == null) {
            return Color.BLACK;
        }

        switch(color.toLowerCase()) {
            case "red":
                return Color.RED;
            case "blue":
                return Color.BLUE;
            case "green":
                return Color.GREEN;
            case "gray":
                return Color.GRAY;
            case "cyan":
                return Color.CYAN;
            case "orange":
                return Color.ORANGE;
            case "pink":
                return Color.PINK;
            default:
                return Color.BLACK;
        }
    }
}
