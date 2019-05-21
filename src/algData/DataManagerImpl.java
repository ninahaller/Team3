package algData;

import java.awt.Image;

import mitVererbung.AbstractImageSource;
import mitVererbung.FilestreamSource;
import mitVererbung.LivestreamSource;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.Box;

import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;

public class DataManagerImpl implements DataManager {
	
	private AbstractImageSource src;

	
	@Override
	public void start(String filesrc) { 
		if (filesrc == null) {
		this.src = new LivestreamSource(0);
		}
		else {
			this.src = new FilestreamSource(filesrc); 
		}
		
		this.src.openConnection(); // f�r hardware Exeption zb "File Not Found"
				
	}
	
	@Override
	
	public BufferedImage getNextImage() {
		if (this.src.isConnected) {
		return (BufferedImage) HighGui.toBufferedImage(this.src.getNextMat());
		}
		else {
			return null;
		}
	}
	
	@Override
	public void stop() {
		this.src.closeConnection();
		
	}

	@Override
	public int berechnen(Box a, Box b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int berechnen() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	@Override
	public int berechnen(Box a, Box b) {
		return Calculation.berechnen2(a.x, a.y, b.x, b.y);
	}
	
	@Override
	public int berechnen() {
		return Calculation.berechnen();
	}
	
	
	private BufferedImage readBufImg() {
		BufferedImage bufImg = (BufferedImage) HighGui.toBufferedImage(null); //readMatFrame()
		return bufImg;
	
	}
*/

}

