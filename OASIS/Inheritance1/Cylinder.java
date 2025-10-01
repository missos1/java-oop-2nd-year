public class Cylinder extends Circle {
    private double height;

    /**
     * Default constructor. Creates a cylinder with default values.
     */
    public Cylinder() {
    }

    /**
     * Creates a cylinder with the given radius.
     *
     * @param radius the radius of the base circle
     */
    public Cylinder(double radius) {
        super(radius);
    }

    /**
     * Creates a cylinder with the given radius and height.
     *
     * @param radius the radius of the base circle
     * @param height the height of the cylinder
     */
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    /**
     * Creates a cylinder with the given radius, height, and color.
     *
     * @param radius the radius of the base circle
     * @param height the height of the cylinder
     * @param color  the color of the cylinder
     */
    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    /**
     * Returns the height of the cylinder.
     *
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the cylinder.
     *
     * @param height the new height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Calculates and returns the volume of the cylinder.
     *
     * @return the volume of the cylinder
     */
    public double getVolume() {
        return super.getArea() * height; // base area * height
    }

    @Override
    public String toString() {
        return "Cylinder[" + super.toString()
        + ",height=" + height + "]";
    }

    @Override
    public double getArea() {
        return 2 * Circle.PI * super.getRadius() * height
        + 2 * super.getArea();
    }
}
