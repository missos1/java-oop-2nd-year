public class Triangle implements GeometricObject {
    private Point p1;
    private Point p2;
    private Point p3;
    
    /**
     * Constructor for Triangle class.
     * 
     * @param p1 The first point of the triangle
     * @param p2 The second point of the triangle
     * @param p3 The third point of the triangle
     * @throws RuntimeException if the points are not valid
     */
    public Triangle(Point p1, Point p2, Point p3) throws RuntimeException {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        if (p1.equals(p2) || p2.equals(p3) || p3.equals(p1)
            || this.getArea() < 1e-9) {
            throw new RuntimeException();
        }
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }
    
    @Override
    public double getArea() {
        double firstterm = p1.getPointX() * (p2.getPointY() - p3.getPointY());
        double secondterm = p2.getPointX() * (p3.getPointY() - p1.getPointY());
        double thirdterm = p3.getPointX() * (p1.getPointY() - p2.getPointY());
        return 0.5 * Math.abs(firstterm + secondterm + thirdterm);
    }

    @Override
    public double getPerimeter() {
        double perimeter = p1.distance(p2) 
        + p2.distance(p3) + p3.distance(p1);
        return perimeter;
    }

    @Override
    public String getInfo() {
        return String.format(
            "Triangle[(%.2f,%.2f),(%.2f,%.2f),(%.2f,%.2f)]",
            p1.getPointX(),
            p1.getPointY(),
            p2.getPointX(),
            p2.getPointY(),
            p3.getPointX(),
            p3.getPointY()
        );
    }
}
