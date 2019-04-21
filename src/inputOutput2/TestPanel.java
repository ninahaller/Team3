package inputOutput2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class TestPanel extends JPanel {

	private BufferedImage image;
	int count = 0;
	
	public TestPanel() {
		super();
	}
	
	
	public void setFace(BufferedImage img) {
		image = img;
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(this.image==null) {
			System.out.println("!! The JPanel image is null !!");
			return;
		}
		
		g.drawImage(this.image, 10, 10, this.image.getWidth(), this.image.getHeight(), null);
		g.setFont(new Font("arial", 2, 20));
		g.setColor(Color.WHITE);
		g.drawString("WebCam processing frame by frame [Frame: " + (count++) + "]", 50, 50);
	}
}
