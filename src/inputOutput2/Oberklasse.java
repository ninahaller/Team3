package inputOutput2;

import org.opencv.core.Mat;

public class Oberklasse {
	
	public boolean opencv = false;
	public boolean openigtlink = false;
	VideoCapturing vc = new VideoCapturing();

	
	public Oberklasse(boolean opencv, boolean openigt) {
		if(opencv == true) {
			this.opencv = true;
			
		}
	}
	
	public Mat read() {
		
		
		return null;
	}

}
