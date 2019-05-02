package mitVererbung;

import java.awt.BorderLayout;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;

public class Main {

	public static void main(String args[]) throws InterruptedException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		final Scanner scan = new Scanner(System.in);
		Data live = new Livestream();
		Data img = new Image();

		JFrame frame = new JFrame("WebCam Capture - Image");
		JPanel main = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);

		frame.setLayout(new BorderLayout());
		main.setLayout(new BorderLayout());
// panel für tespanel
		Panel panel = new Panel();

		main.add(panel, BorderLayout.CENTER);

		frame.getContentPane().add(main);
		frame.validate();
		frame.setVisible(true);

		System.out.println("Bitte geben Sie '1' für Livestream oder '0' für Video/Bild  ein");
		int checkStart = scan.nextInt();

		if (checkStart == 1) {
			live.getOpenCVLivestream();

			// Loop for reading a BufferedImage and painting it on a panel;
			while (live.open) {
				panel.setFace(live.readBufImg());
				panel.fps =live.fps;
				panel.repaint();

			}

		} else if (checkStart == 0) {
			final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			int returnVal = fc.showOpenDialog(fc);
			String loadFile = null;

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				loadFile = fc.getSelectedFile().getAbsolutePath();
				img.getOpenCVImage(loadFile);

				while (img.open) {
					panel.setFace(img.readBufImg());
					try {
						Thread.sleep(25);
					} catch (InterruptedException es) {
						// TODO Auto-generated catch block
						es.printStackTrace();
					}
					panel.fps = img.fps;
					panel.repaint();

				}

			}
		}

	}
}
