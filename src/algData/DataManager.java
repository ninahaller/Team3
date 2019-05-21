package algData;

import java.awt.image.BufferedImage;

import javax.swing.Box;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;



public interface DataManager {
		void stop();
		
		// src=null für live
		void start(String src); 
		BufferedImage getNextImage();
		
		int berechnen(Box a, Box b);
		int berechnen();
	}
/*
	public BufferedImage bufImg = null;
	public static Mat frameMatrix;
	
	public DataManager(){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		frameMatrix = new Mat();
	}
	
	
	 source = new AbstractImageSource();
	//ls = new LivestreamSource(0);
	
	//source.openConnection();
	
	//Mat = source.getNextMat();
	
	
	while(source.openConnection) {
		Mat = source.getNextMat();
	}
	return true;
	


	
	
	public BufferedImage readBufImg(){
		bufImg = (BufferedImage) HighGui.toBufferedImage(Mat);
		return bufImg;
	}

}*/

