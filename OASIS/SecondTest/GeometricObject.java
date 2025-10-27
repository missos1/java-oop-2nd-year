public interface GeometricObject {
    /** Get shape's area.
     * 
     * @retur shape's area
     */
    public abstract double getArea();

    /**
     * Get shape's perimeter.
     * 
     * @return shape's perimeter.
     */
    public abstract double getPerimeter();

    /**
     * Get shape's info.
     * 
     * @return shape's info.
     */
    public abstract String getInfo();
}
