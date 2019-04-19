package inputOutput;

import java.awt.Image;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.Videoio;
import org.opencv.videoio.VideoCapture;

public class liveStream{
  static {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
  }
  
  
   static JLabel imageLabel;
   static int fps;
  /**
   * .
   * @param args
   **/
  
  
  public static void main(String[] args) {
	   new testGui();
	   liveStream app = new liveStream();
	   app.runMainLoop(args);
  }



  private void runMainLoop(String[] args) {

    ImageProcessor imageProcessor = new ImageProcessor();
    Mat webcamMatImage = new Mat();
    Image tempImage;

    Scanner scan = new Scanner(System.in);
    int file = scan.nextInt();
    if (file == 0) { // if 0 is selected the livestream of the input video source(0) will start
      
      VideoCapture capture = new VideoCapture(0); //videocapture to find source of video input
      int x = (int) capture.get(Videoio.CAP_PROP_FRAME_WIDTH); //x = original width of the image
      int y = (int) capture.get(Videoio.CAP_PROP_FRAME_HEIGHT); // y = original height of the image
      
      capture.set(Videoio.CAP_PROP_FRAME_WIDTH,x);
      capture.set(Videoio.CAP_PROP_FRAME_HEIGHT,y);
      
      System.out.println(capture.get(Videoio.CAP_PROP_FRAME_WIDTH));
      System.out.println(capture.get(Videoio.CAP_PROP_FRAME_HEIGHT));
       fps = (int) capture.get(Videoio.CAP_PROP_FPS);
      
      if (capture.isOpened()) {
        while (true) {
          capture.read(webcamMatImage);
          System.out.println(fps);
          if (!webcamMatImage.empty()) {
            tempImage = imageProcessor.toBufferedImage(webcamMatImage);
            ImageIcon imageIcon = new ImageIcon(tempImage, "Captured video");
            imageLabel.setIcon(imageIcon);
          } else {
            System.out.println(" -- Frame not captured -- Break!");
            break;
          }
        }
      } else {
        System.out.println("Couldn't open capture.");
      }
    } else if (file == 1) { //if 1 is selected filechooser will open and you can browse to your files to open video or normale image

      final JFileChooser fc = 
          new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); // filechooser will open the explorer 
      int returnVal = fc.showOpenDialog(fc);
      String loadFile = null;
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        loadFile = fc.getSelectedFile().getAbsolutePath();
        
        VideoCapture capture = new VideoCapture(loadFile);  //videocapture to find source of video input
        int x = (int) capture.get(Videoio.CAP_PROP_FRAME_WIDTH);
        int y = (int) capture.get(Videoio.CAP_PROP_FRAME_HEIGHT);
 
        capture.set(Videoio.CAP_PROP_FRAME_WIDTH,x);
        capture.set(Videoio.CAP_PROP_FRAME_HEIGHT,y);

        System.out.println(capture.get(Videoio.CAP_PROP_FRAME_WIDTH));
        System.out.println(capture.get(Videoio.CAP_PROP_FRAME_HEIGHT));

        if (capture.isOpened()) {
          while (true) {
             fps =  (int) capture.get(Videoio.CAP_PROP_FPS);
            try {
              Thread.sleep(fps);
            } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
            capture.read(webcamMatImage);
            System.out.println(fps);
            if (!webcamMatImage.empty()) {
              tempImage = imageProcessor.toBufferedImage(webcamMatImage);
              ImageIcon imageIcon = new ImageIcon(tempImage, "Captured video");
              imageLabel.setIcon(imageIcon);
            } else {
              System.out.println(" -- Frame not captured -- Break!");
              break;
            }
          }
        } else {
          System.out.println("Couldn't open capture.");
        }
      }
    }
  }
}

