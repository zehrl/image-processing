import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Helps easily display images in a window. Used alongside @ImageProcessor usually.
 */
public class ImageProcessorViewer {
   private JPanel panel;
   private JFrame frame;

   public ImageProcessorViewer(String title) {
      panel = new JPanel();

      this.frame = new JFrame(title);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null); // center on screen
   }

   public void add(Image image) {
      JLabel label = new JLabel(new ImageIcon(image));
      this.panel.add(label);
      this.frame.add(this.panel);

   }

   public void createWindow() {
      this.frame.pack(); // size frame to fit image
      this.frame.setVisible(true);
   }
}
