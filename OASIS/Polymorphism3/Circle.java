// package Polymorphism2;

import java.awt.Graphics;

public class Circle extends Shape {
    protected double radius;
    protected Point center;

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

    /**
     * Constructor with 4 parameters.
     * 
     * @param center of the circle
     * @param radius of the circle
     * @param color of the circle
     * @param filled fill the circle or not
     */
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
        this.center = center;
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

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
             return true;
        }
        if (!(o instanceof Circle)) {
            return false;
        }

        Circle temp = (Circle) o;
        return temp.radius == radius && temp.center.equals(center);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        long temp = Double.doubleToLongBits(radius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((center == null) ? 0 : center.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return "Circle[center=" + center.toString() + ",radius=" + radius
        + ",color=" + color + ",filled=" + filled + "]";
    }

    @Override
    public void move() {

    }

    @Override
    public void draw(Graphics g) {
        int x = (int) (center.getPointX() - radius);
        int y = (int) (center.getPointY() - radius);

        int diameter = (int) (2 * radius);

        g.setColor(stringToColor(this.color));

        if (filled) {
            g.fillOval(x, y, diameter, diameter);
        } else {
            g.drawOval(x, y, diameter, diameter);
        }
    }
}
