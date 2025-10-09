// package Polymorphism2;

public class Square extends Rectangle {
    /**
     * Default constructor with no parameter.
     */
    public Square() {

    }

    /**
     * Constructor with side parameter.
     * 
     * @param side of the square
     */
    public Square(double side) {
        width = side;
        length = side;
    }

    /**
     * Constructor with 3 parameters.
     * 
     * @param side of the square
     * @param color of the square
     * @param filled fill the square or not
     */
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    /**
     * Constructor with 4 parameters.
     * 
     * @param topLeft of the square
     * @param side of the square
     * @param color of the square
     * @param filled fill the square or not
     */
    public Square(Point topLeft, double side, String color, boolean filled) {
        super(topLeft, side, side, color, filled);
    }

    /**
     * Gets square's side.
     * 
     * @return side of the square
     */
    public double getSide() {
        return width;
    }

    /**
     * Sets square's side.
     * 
     * @param side of the square
     */
    public void setSide(double side) {
        width = side;
        length = side;
    }

    /**
     * Sets square's side.
     */
    public void setWidth(double side) {
        width = side;
        length = side;
    }

    /**
     * Sets square's side.
     */
    public void setLength(double side) {
        width = side;
        length = side;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Square[topLeft=" + topLeft.toString() + ",side=" 
        + width + ",color=" + color + ",filled=" + filled + "]";
    }

    @Override
    public void move() {

    }

    @Override
    public void draw(Graphics g) {

    }
}
