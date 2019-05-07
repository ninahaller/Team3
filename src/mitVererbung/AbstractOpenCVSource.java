package mitVererbung;

import java.awt.image.BufferedImage;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public abstract class AbstractOpenCVSource extends AbstractImageSource{

	public static VideoCapture vc;
	public static boolean open = false;
	public static Mat frameMatrix;
	public static BufferedImage bufImg = null;
	public static int fps;

	public AbstractOpenCVSource() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		frameMatrix = new Mat();
	}

	public abstract Mat readMatFrame();

	public abstract BufferedImage readBufImg();

	public void getOpenCVLivestream() {
		LivestreamSource live = new LivestreamSource();
		live.capture();

	}

	public void getOpenCVImage(String path) {
		FilestreamSource img = new FilestreamSource();
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
