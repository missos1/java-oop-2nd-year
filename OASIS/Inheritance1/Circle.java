public class Circle {
    private double radius;
    private String color;
    protected static final double PI = Math.PI; 

    /**
     * Default constructor. Creates a circle with default values.
     */
    public Circle() {
    }

    /**
     * Creates a circle with the given radius.
     *
     * @param radius the radius of the circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Creates a circle with the given radius and color.
     *
     * @param radius the radius of the circle
     * @param color  the color of the circle
     */
    public Circle(double radius, String color) {
        this.color = color;
        this.radius = radius;
    }

    /**
     * Returns the radius of the circle.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle.
     *
     * @param radius the new radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Returns the color of the circle.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the circle.
     *
     * @param color the new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Calculates and returns the area of the circle.
     *
     * @return the area of the circle
     */
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius 
        + ",color=" + color + "]"; 
    }
}
