import java.util.Objects;

public class Point {
    private double pointX; 
    private double pointY;


    /**
     * Constructor with 2 parameters.
     * 
     * @param pointX of the point
     * @param pointY of the point
     */
    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
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
     * Gets the distance between 2 points.
     * 
     * @param newPoint the other point
     * @return the distance between them
     */
    public double distance(Point newPoint) {
        double xlenght = newPoint.pointX - pointX; 
        double ylenght = newPoint.pointY - pointY; 

        return Math.sqrt(xlenght * xlenght + ylenght * ylenght);
    } 

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }

        Point temp = (Point) o;
        return temp.pointX == pointX && temp.pointY == pointY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

    @Override
    public String toString() {
        return String.format("(%.1f,%.1f)", pointX, pointY);
    }
}
