package inputOutput2;

import java.util.Scanner;

import javax.swing.JFrame;

public class TestMain {

	public static void main(String args[]) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		VideoCapturing vc = new VideoCapturing();

		JFrame frame = new JFrame("WebCam Capture - Image");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		TestPanel panel = new TestPanel();
		frame.setContentPane(panel);
		frame.setVisible(true);

		System.out.println("Bitte geben Sie 'Y' für Start ein");
		String checkStart = scan.next();

		//The datatransport starts after user interaction. Here a Scanner have replaced the subsequent Button;
		if (checkStart.equals("Y")) {
			vc.capture();

			// Loop for reading a BufferedImage and painting it on a panel;
			while (vc.open) {
				panel.setFace(vc.setBufImg());
				panel.repaint();

			}
		}

	}

}
