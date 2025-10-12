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

    public void checkCollision(Shape shape ,int width, int height) {
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            Point center = c.getCenter();
            int radius = (int) c.getRadius();

            if (center.getPointX() + radius > width || center.getPointX() - radius < 0) {
                c.setDx(-c.getDx());
                if (center.getPointX() + radius > width) {
                    center.setPointX(width - radius);
                }
            } else if (center.getPointX() - radius < 0) {
                center.setPointX(width + radius);
            }

            if (center.getPointY() + radius > height || center.getPointY() - radius < 0) {
                c.setDy(-c.getDy());
                if (center.getPointY() + radius > height) {
                    center.setPointY(height - radius);
                }
            } else if (center.getPointY() - radius < 0) {
                center.setPointY(height + radius);
            }
        } else {
            Rectangle r = (Rectangle) shape;

            Point topLeft = r.getTopLeft();
            int w = (int) r.getWidth();
            int h = (int) r.getLength();
            
            if (topLeft.getPointX() + w > width || topLeft.getPointX() < 0) {
                r.setDx(-r.getDx());
                if (topLeft.getPointX() + w > width) {
                    topLeft.setPointX(width - w);
                }
            } else if (topLeft.getPointX() < 0) {
                topLeft.setPointX(width);
            }

            if (topLeft.getPointY() + h > height || topLeft.getPointY() < 0) {
                r.setDy(-r.getDy());
                if (topLeft.getPointY() + h > height) {
                    topLeft.setPointY(height - h);
                }
            } else if (topLeft.getPointY() < 0) {
                topLeft.setPointY(height);
            }
        }
    }
    
    private void checkCircletoCirlceColli(Circle circle1, Circle circle2) {

    }

    private void checkCircletoRect(Circle circle, Rectangle rectangle) {

    }

    @Override 
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        int currentWidth = getWidth();
        int currentHeight = getHeight();

        for (Shape s : shapes) {
            checkCollision(s, currentWidth, currentHeight);
            s.move();
            s.draw(g);
        }
    }
}
