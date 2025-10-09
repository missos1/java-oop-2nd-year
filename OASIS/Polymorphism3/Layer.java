import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;

public class Layer extends JPanel {
    private List<Shape> shapes = new ArrayList<>();

    /**
     * Adds shape to the layer.
     * 
     * @param shape the shape to be added
     */
    public void addShape(Shape shape) {
        if (shape != null) {
            shapes.add(shape);
        }
    }   

    /**
     * Removes all circle of the layer.
     */
    public void removeCircles() {
        shapes.removeIf(s -> (s instanceof Circle));
    }
    
    /**
     * Return layer details in string format.
     * 
     * @return layer details in string format.
     */
    public String getInfo() {
        String info = "Layer of crazy shapes:\n";
        for (Shape s : shapes) {
            info += s.toString() + "\n";
        }

        return info;
    }

    /**
     * Removes dupes from layer using Set data structure.
     */
    public void removeDuplicates() {
        shapes = new ArrayList<>(new LinkedHashSet<>(shapes));
    }

    @Override 
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        for (Shape s : shapes) {
            s.draw(g);
        }
    }
}
