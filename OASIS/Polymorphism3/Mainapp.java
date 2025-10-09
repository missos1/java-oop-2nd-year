import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Mainapp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Shape simulator");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 600);

        Layer drawingLayer = new Layer();

        int delay = 16;

        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                drawingLayer.repaint();
            }
        });

        timer.start();

        drawingLayer.addShape(new Circle(new Point(100, 100), 100, "red", true));
    
        frame.add(drawingLayer);

        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}
