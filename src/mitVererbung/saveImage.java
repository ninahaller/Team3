package mitVererbung;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import algData.DataManager;

public class saveImage {
	
	private DataManager datamanager;
	BufferedImage bufImg = this.datamanager.getNextImage();
	


	public void save(){
		
		//BufferedImage bufImg;
		
		//bufImg=this.datamanager.getNextImage();

		File output = new File("SavedImage1.png");
		
		int i = 0;
		
		while(output.exists()) {
			i++;
			output = new File("savedImage " + i + ".png");
			
		}	
	
			
			try {
				ImageIO.write(bufImg,"png", output);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
    	
	}

}


