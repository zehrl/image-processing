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

      // SCALE IMAGE
      int width = imageProcessor.getImage().getWidth();
      int height = imageProcessor.getImage().getHeight();
      double scale = 0.3;

      Image scaled = imageProcessor.getImage().getScaledInstance((int) (width * scale), (int) (height * scale), Image.SCALE_SMOOTH);
      Image scaledGrayscale = grayscale.getScaledInstance((int) (width * scale), (int) (height * scale), Image.SCALE_SMOOTH);
      // SCALE IMAGE

      ImageProcessorViewer imagePV = new ImageProcessorViewer("Grayscale Demonstration");

      imagePV.add(scaled);
      imagePV.add(scaledGrayscale);
      imagePV.createWindow();
   }
}
