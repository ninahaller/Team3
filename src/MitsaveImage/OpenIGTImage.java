package src.MitsaveImage;

import java.awt.Color.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.medcare.igtl.messages.ImageMessage;
import org.medcare.igtl.util.IGTImage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class OpenIGTImage extends ImageSource {
	private String ipAddress = "127.0.0.1";
	private int port = 18944;

	
	private OpenIGTLink igt = new OpenIGTLink(ipAddress, port);
	
	Mat mat;
	
	public OpenIGTImage() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	
	public BufferedImage update() {
	
//		System.out.println(igt.name);
//		imgMsg = igt.imageMessage;
//		System.out.println(imgMsg);

//		try {
//			InputStream in = new ByteArrayInputStream(imgMsg.getBody());
//			bf = ImageIO.read(in);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	
//		System.out.println(igt.imageMessage.getMatrix().toString());
		imgMsg = igt.imageMessage;
		boolean ok = false;
		byte[] body=null;
		byte[] data = null;
		
	    try {
			ok = imgMsg.UnpackBody();
			body = imgMsg.PackBody();
			data = imgMsg.getImageData();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ok + " --- body length: " + body.length + " --- data length: " + data.length + " --- header length: " + imgMsg.getImageHeader().length);
	   
		//data.length = 307200 (640x480)
	  
		Mat mat = new Mat();

		//mat.put(int rows, int cols, byte[] data);
		
		
		
		MatOfByte mb = new MatOfByte(data);
	
		

		System.out.println("Matrix!!!! cols: " + mat.cols() + " --- rows: " + mat.rows() + " --------- matofbyte: " + mb.cols());
		
		
		
		
		
//		try {
////			InputStream in = new ByteArrayInputStream(b);
////			bf = ImageIO.read(in);
//			mat = Imgcodecs.imdecode(new MatOfByte(data), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
//			bf= (BufferedImage) HighGui.toBufferedImage(mat);
//			System.out.println(data.toString());
//			System.out.println(mat.cols());
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		IGTImage img = new IGTImage(imgMsg, data);
//		ImageMessageMatrix(imgMsg.getMatrix());
//		return img.getBufferedImage();
		return bf;

	}
	
//	public void ImageMessageMatrix(double matrix [][])
//
//	{
//		
//	  mat[0][0] = matrix[0][0];
//
//	  mat[1][0] = matrix[1][0];
//
//	  mat[2][0] = matrix[2][0];
//
//	  mat[3][0] = matrix[3][0];
//
//
//
//	  mat[0][1] = matrix[0][1];
//
//	  mat[1][1] = matrix[1][1];
//
//	  mat[2][1] = matrix[2][1];
//
//	  mat[3][1] = matrix[3][1];
//
//
//
//	  mat[0][2] = matrix[0][2];
//
//	  mat[1][2] = matrix[1][2];
//
//	  mat[2][2] = matrix[2][2];
//
//	  mat[3][2] = matrix[3][2];
//
//
//
//	  mat[0][3] = matrix[0][3];
//
//	  mat[1][3] = matrix[1][3];
//
//	  mat[2][3] = matrix[2][3];
//
//	  mat[3][3] = matrix[3][3];
//	  
//	  for(int i=0; i<matrix.length; i++) {
//		  for(int j=0; j<matrix[i].length; j++) {
//			  System.out.println(matrix[i][j]);
//		  }
//	  }
//	}

}
