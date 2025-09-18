import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * An image processor with a few neat processing methods and algorithms. Just construct
 * an ImageProcessor using a file location pointing to an image.
 */
public class ImageProcessor {
   private BufferedImage image;

   /**
    * Constructs an ImageProcessor using the project root file path
    *
    * @param file The file location of the image
    */
   public ImageProcessor(File file) {
      try {
         // TODO: turn into logging instead of print statement
         System.out.println(file.getAbsolutePath());
         this.image = ImageIO.read(file);
      } catch (IOException e) {
         // TODO: turn into logging instead of print statement
         System.out.println(e);
      }
   }

   /**
    * Processes the image into grayscale.
    *
    * @return BufferedImage
    */
   public BufferedImage toGrayscale() {

      int width = this.image.getWidth();
      int height = this.image.getHeight();

      BufferedImage grayscaleImage = new BufferedImage(width, height, 1);

      for (int y = 0; y < height; y++) {
         for (int x = 0; x < width; x++) {
            int p = this.image.getRGB(x, y);
            int a = (p >> 24) & 0xff;
            int r = (p >> 16) & 0xff;
            int g = (p >> 8) & 0xff;
            int b = p & 0xff;
            int avg = (r + g + b) / 3;
            p = (a << 24) | (avg << 16) | (avg << 8) | avg;
            grayscaleImage.setRGB(x, y, p);
         }
      }

      return grayscaleImage;

   }

   /**
    * Get the original image
    * @return BufferedImage
    */
   public BufferedImage getImage() {
      return image;
   }
}
