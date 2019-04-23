package InputOutPut3;





import java.awt.image.BufferedImage;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class VideoCapturing {
	private VideoCapture vc;
	public boolean open = false;
	public Mat frameMatrix;
	public BufferedImage bufImg = null;
	public int fps;
	
	// BufferedImage bufImg = null;
	public VideoCapturing() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		frameMatrix = new Mat();
	}

	public void capture() {

		System.out.println("capDev");
		vc = new VideoCapture(0);

		if (vc.isOpened()) {
			System.out.println("found VideoSource " + vc.toString());
			open = true;

		} else {
			System.out.println("!!! Did not connect to camera !!!");
		}

	}

	public void capture(String path) {
		System.out.println("capFile");
		vc = new VideoCapture(path);
		if (vc.isOpened()) {
			
			System.out.println("found VideoSource " + vc.toString());
			open = true;


		} else {
			System.out.println("!!! Did not connect to camera !!!");
		}
	}

	public Mat readMatFrame() { // k�nnte auch getNextFrame hei�en;
		// System.out.println("Hello");
		System.out.println((int) vc.get(Videoio.CAP_PROP_FPS));
		fps = (int) vc.get(Videoio.CAP_PROP_FPS);
		vc.read(frameMatrix);
		
		if (frameMatrix.empty()) {
			System.out.println("!!! Nothing captured from webcam !!!");
		}

		return frameMatrix;

	}

	public BufferedImage setBufImg() {
		// System.out.println("Hello2");
		bufImg = (BufferedImage) HighGui.toBufferedImage(readMatFrame());
		return bufImg;

	}

	public void releaseDevice() {
		vc.release();
		open = false;
	}
	


}
