package MitsaveImage;

import java.awt.image.BufferedImage;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public abstract class Data1 {

	public static VideoCapture vc;
	public static boolean open = false;
	public static Mat frameMatrix;
	public static BufferedImage bufImg = null;
	public static int fps;

	public Data1() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		frameMatrix = new Mat();
	}

	public abstract Mat readMatFrame();

	public abstract BufferedImage readBufImg();

	public void getOpenCVLivestream() {
		LiveStream1 live = new LiveStream1();
		live.capture();

	}
	public void SaveImg() {
		saveImage1 saveImg = new saveImage1();
		//saveImg.capture();
		saveImg.save();
	}
	
	public void getOpenCVImage(String path) {
		Image1 img = new Image1();
		img.capture(path);
	}
}
