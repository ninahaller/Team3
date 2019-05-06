package MitsaveImage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class saveImage1 extends Data1 {
	public saveImage1() {
		super();
	}
	

	/*public void capture() {
		
		System.out.println("capDev");
		vc = new VideoCapture(0);
		
		if(vc.isOpened()) {
			System.out.println("found VideoSource " + vc.toString());
			open = true;
		}else {
			System.out.println("!!! Did not connect to camera !!!");
		}
		
	}*/
	
	public Mat readMatFrame() { // könnte auch getNextFrame heißen;
		// System.out.println("Hello");
		System.out.println((int) vc.get(Videoio.CAP_PROP_FPS));
		fps = (int) vc.get(Videoio.CAP_PROP_FPS);
		vc.read(frameMatrix);
		
		if (frameMatrix.empty()) {
			System.out.println("!!! Nothing captured from webcam !!!");
		}

		return frameMatrix;

	}

	public void save(){
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    	int returnVal = chooser.showSaveDialog(null);
    	
    	File file = chooser.getSelectedFile();
    	if(returnVal == JFileChooser.APPROVE_OPTION) {
//   		File file chooser.getSelectedFile(); //soll im Kommentar bleiben!
    	}
		try {
			ImageIO.write(bufImg,"png",file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    
	}
	
	
	public BufferedImage readBufImg() {
		// System.out.println("Hello2");
		bufImg = (BufferedImage) HighGui.toBufferedImage(readMatFrame());
		return bufImg;

	}

	public void releaseDevice() {
		vc.release();
		open = false;
}
}
