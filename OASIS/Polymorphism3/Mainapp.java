import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Mainapp {
    public final Random random = new Random();
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

        int width = frame.getWidth();
        int height = frame.getHeight();
        Mainapp mainapp = new Mainapp();

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int speedX = mainapp.randomSpeed(10, -10);
                int speedY = mainapp.randomSpeed(10, -10);
                String color = mainapp.randomColor();
                boolean filled = mainapp.random.nextBoolean();
                int radius =  mainapp.random.nextInt(40) + 5;
                int rectWidth = mainapp.random.nextInt(70) + 10;
                int rectHeight = mainapp.random.nextInt(70) + 10;

                if (e.getKeyChar() == 'c' || e.getKeyChar() == 'C') {
                    Point center = new Point(width / 2, height / 2);
                    
                    drawingLayer.addShape(new Circle(center, radius, color, filled, speedX, speedY));
                }

                if (e.getKeyChar() == 'r' || e.getKeyChar() == 'R') {
                    Point center = new Point(width / 2, height / 2);

                    drawingLayer.addShape(new Rectangle(center, rectWidth, rectHeight, color, filled, speedX, speedY));
                }

                if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
                    Point center = new Point(width / 2, height / 2);

                    drawingLayer.addShape(new Square(center, rectWidth,  color, filled, speedX, speedY));
                }

                if (e.getKeyChar() == ']') {
                    drawingLayer.removeCircles();
                }
            }
        });

        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                drawingLayer.repaint();
            }
        });

        timer.start();
    
        frame.add(drawingLayer);

        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }

    private String randomColor() {
        String[] colors = {"red", "blue", "green", "gray", "cyan", "orange", "pink"};
        return colors[random.nextInt(colors.length)];
    }

    private int randomSpeed(int max, int min) {
        int speed = random.nextInt(max + 1 - min) + min;
        return speed != 0 ? speed : 1;
    }
}
