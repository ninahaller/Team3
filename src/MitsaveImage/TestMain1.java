package MitsaveImage;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;

public class TestMain1 implements ActionListener{
	
	public static void main(String args[]) throws InterruptedException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		final Scanner scan = new Scanner(System.in);
		Data1 live = new LiveStream1();
		Data1 img = new Image1();
		Data1 saveImg = new saveImage1();
		
		JButton save1 = new JButton("save");
//		save1.addActionListener(this);

		JFrame frame = new JFrame("WebCam Capture - Image");
		JPanel main = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);

		frame.setLayout(new BorderLayout());
		main.setLayout(new BorderLayout());
// panel für tespanel
		TestPanel1 panel = new TestPanel1();
		
		JPanel panelB = new JPanel();
		panelB.setLayout(new FlowLayout());
		panelB.add(save1);

		main.add(panel, BorderLayout.CENTER);
		main.add(panelB, BorderLayout.PAGE_END);
	
		
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
		
		
		else if(checkStart == 2) {
			saveImg.getOpenCVLivestream();
			while (saveImg.open) {
				panel.setFace(saveImg.readBufImg());
				panel.fps =saveImg.fps;
				panel.repaint();
				
		
		save1.addActionListener(new ActionListener() {
			
       @Override
       	public void actionPerformed(ActionEvent e) {
   			
    	   if( e.getSource() == save1) {
    		   saveImg.SaveImg();
    	   }
    	} 
		});
			}
			}
		}
		
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
