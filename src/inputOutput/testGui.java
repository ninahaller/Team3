package inputOutput;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class testGui extends JFrame{
	
	
	 JFrame frame;

	public static void main(String[] args) {
		}
	
	
	
	public testGui() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			frame = new JFrame("test");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(1920,1080);
		    frame.setVisible(true);
		    
		    liveStream.imageLabel = new JLabel();
		    frame.add(liveStream.imageLabel);
		    
		    
//		    Graphics g = frame.getGraphics();
//		    frame.paint(g);
//		    g.setColor(Color.WHITE);
//		    g.drawString("FPS number: " + liveStream.fps, 400,200);
		    //frame.pack();
		    
	
	}
	}

