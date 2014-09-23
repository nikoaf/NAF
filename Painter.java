import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Painter extends JFrame {
    private int pointCount = 0;
    private Point points [] = new Point [100000];
    
    public Painter () {
    	super ("Program Menggambar Sederhana");
    	getContentPane().add(new JLabel("Drag Mouse to Draw"), BorderLayout.SOUTH);
    	addMouseMotionListener (
    		new MouseMotionAdapter() {
    			public void mouseDragged (MouseEvent e) {
    				if (pointCount < points.length) {
    					points[pointCount] = e.getPoint();
    					++pointCount;
    					repaint();
    				}
    			}
    		}
    	);
    	setSize (800,600);
    	setLocationRelativeTo(null);
    	setVisible(true);
    }
    
    public void paint (Graphics g) {
    	super.paint(g);
    	for (int i = 0; i < points.length && points[i] != null; i++) {
    		g.setColor(Color.black);
    		g.fillOval (points[i].x, points[i].y, 4,4);
    	}
    }
    
    public static void main (String args[]) {
    	Painter test = new Painter();
    	test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}