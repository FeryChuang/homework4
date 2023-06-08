package homework4.prog;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class imgDisplay extends Frame{
    private static Image image;
    
    public imgDisplay(String imagePath) {
	        image = Toolkit.getDefaultToolkit().getImage(imagePath);
	        setVisible(true);
	    }

	    public void paint(Graphics g) {
	        g.drawImage(image, 0, 0, this);
	    }

	    public static void displayImage(String imagePath) {
	        new imgDisplay(imagePath);
	    }

	    public static void main(String[] args) {
	        displayImage("/homework4/img/shop logo-black.jpg");
	    }
	    
}



