import java.util.List;

public class ShapeUtil {
    /**
     * Returns info from a list of geometric object.
     * 
     * @param shapes the list contains geometric object
     * @return the info String
     */
    public String printInfo(List<GeometricObject> shapes) {
        String resultCircles = "Circle:\n";
        String resultTriangles = "Triangle:\n";
        for (GeometricObject obj : shapes) {
            if (obj instanceof Circle) {
                resultCircles += obj.getInfo() + "\n";
            } else {
                resultTriangles += obj.getInfo() + "\n";
            }
        }
        return resultCircles + resultTriangles;
    }
}
