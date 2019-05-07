package src.MitsaveImage;

import java.awt.image.BufferedImage;

import org.medcare.igtl.messages.ImageMessage;
import org.opencv.core.Mat;

import Jama.Matrix;

public abstract class ImageSource {

	protected Mat mat;
	protected BufferedImage bf;
	
	protected ImageMessage imgMsg; //for OpenIGTLink;
	protected Matrix matigt;
	
	public abstract BufferedImage update();
	
	public BufferedImage getNextFrame() {
		return bf;
	}
	
	
	
}
