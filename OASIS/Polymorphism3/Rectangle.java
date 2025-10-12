// package Polymorphism2;

import java.awt.Graphics;

public class Rectangle extends Shape {
    protected double width;
    protected double length;
    protected Point topLeft;

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
        super(color, filled, 0 , 0);
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor with 7 parameters.
     * 
     * @param topLeft of the rectangle
     * @param width of the rectangle
     * @param length of the rectangle
     * @param color of the rectangle
     * @param filled fill the rectangle or not
     * @param dx x axis velocity of the rectangle
     * @param dy y axis velocity of the rectangle
     */
    public Rectangle(Point topLeft, double width, double length, String color,
    boolean filled, double dx, double dy) {
        super(color, filled, dx, dy);
        this.topLeft = topLeft;
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
    
    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
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
        return "Rectangle[topLeft=" + topLeft.toString() + ",width=" + width 
        + ",length=" + length + ",color=" + color
        +  ",filled=" + filled + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(width);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(length);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((topLeft == null) ? 0 : topLeft.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Rectangle other = (Rectangle) o;
        if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width)) {
            return false;
        }
        if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length)) {
            return false;
        }
        if (topLeft == null) {
            if (other.topLeft != null) {
                return false;
            }
        } else if (!topLeft.equals(other.topLeft)) {
            return false;
        }
        return true;
    }
    
    @Override
    public void move() {
        topLeft.setPointX(topLeft.getPointX() + dx);
        topLeft.setPointY(topLeft.getPointY() + dy);
    }

    @Override
    public void draw(Graphics g) {
        int x = (int) topLeft.getPointX();
        int y = (int) topLeft.getPointY();
        int w = (int) width;
        int h = (int) length;

        g.setColor(stringToColor(this.color));

        if (filled) {
            g.fillRect(x, y, w, h);
        } else {
            g.drawRect(x, y, w, h);
        }
    }
}

