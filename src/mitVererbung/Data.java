package mitVererbung;

import java.awt.image.BufferedImage;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public abstract class Data {

	public static VideoCapture vc;
	public static boolean open = false;
	public static Mat frameMatrix;
	public static BufferedImage bufImg = null;
	public static int fps;

	public Data() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		frameMatrix = new Mat();
	}

	public abstract Mat readMatFrame();

	public abstract BufferedImage readBufImg();

	public void getOpenCVLivestream() {
		Livestream live = new Livestream();
		live.capture();

	}

	public void getOpenCVImage(String path) {
		Image img = new Image();
		img.capture(path);
	}

//	public void getOpenIGTLivestream() {
////		kommt noch
//	}
//
//	public void setImage() {
////		kommt noch
//	}

}
