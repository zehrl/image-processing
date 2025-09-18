import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
   public static void main(String[] args) {

      // Setup image
      String pathName = "images/dolphins_jumping.jpg";
      File file = new File(pathName);

      ImageProcessor imageProcessor = new ImageProcessor(file);
      System.out.println("imageProcessor image: " + imageProcessor.getImage());

      BufferedImage grayscale = imageProcessor.toGrayscale();
      System.out.println("gray scale image: " + grayscale);

      // Show in a popup window
      ImageProcessorViewer imagePV = new ImageProcessorViewer("Grayscale Demonstration");
      imagePV.add(imageProcessor.getImage());
      imagePV.add(grayscale);
      imagePV.createWindow();


      // JFrame frame = new JFrame("Grayscale Preview");
      // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //
      // int maxHeight = 500; //px
      // int width = imageProcessor.getImage().getWidth();
      // int height = imageProcessor.getImage().getHeight();
      // double scale = 0.3;
      //
      // Image scaledImage = imageProcessor.getImage().getScaledInstance((int) (width * scale), (int) (height * scale), Image.SCALE_SMOOTH);
      // Image scaledGrayscale = grayscale.getScaledInstance((int) (width * scale), (int) (height * scale), Image.SCALE_SMOOTH);
      //
      // JLabel label = new JLabel(new ImageIcon(scaledImage));
      // JLabel grayscaleLabel = new JLabel(new ImageIcon(scaledGrayscale));
      //
      // JPanel panel = new JPanel();
      // panel.add(label);
      // panel.add(grayscaleLabel);
      //
      // frame.add(panel);
      // frame.pack(); // size frame to fit image
      // frame.setLocationRelativeTo(null); // center on screen
      // frame.setVisible(true);
   }
}
