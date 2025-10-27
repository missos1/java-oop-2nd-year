public class Point {
    private double pointX;
    private double pointY;
    
    /**
     * Constructor for Point class.
     * 
     * @param x x position in cartesian space
     * @param y y position in cartesian space
     */
    public Point(double x, double y) {
        pointX = x;
        pointY = y;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /**
     * Calculates the distance between this point and another point.
     * 
     * @param other The other point
     * @return The distance between the two points
     */
    public double distance(Point other) {
        double tempX = pointX - other.pointX;
        double tempY = pointY - other.pointY;
        
        return Math.sqrt(tempX * tempX + tempY * tempY);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point temp = (Point) o;
            if (temp != null) {
                return pointX == temp.pointX && pointY == temp.pointY;
            }
        }
        return false;
    }
}
