package inputOutput;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;import org.opencv.videoio.Videoio;

public class testGui extends JFrame{
	
	
	 JFrame frame;
	 
	JLabel label;
	
	
	public testGui() {

		
		
			
		    
		   
		    init();
		    
}
	
	public void  init() {
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
		
		 frame = new JFrame("windows");
	
		 frame.setVisible(true);
		 frame.setSize(500,500);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		
		 
		 liveStream.imageLabel = new JLabel();
		 
		 frame.add(liveStream.imageLabel);
		 
		
		
		
		 
		 
	}
	public static void main(String[] args) {
		
		new liveStream(); 
		
	}

	}

