import javax.imageio.ImageIO;
import java.awt.*;
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
    * @return The original {@link BufferedImage} but in grayscale
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
    *
    * @return BufferedImage
    */
   public BufferedImage getImage() {
      return image;
   }

   // TODO: Add scaling method
   // /**
   //  * Scales the image proportionally by a percentage represented by a decimal (ex. 0.5 = 50% the size)
   //  * @param scale The amount to scale the image by
   //  * @return The original {@link BufferedImage} image but scaled up or down
   //  */
   // public BufferedImage scaleImage(double scale) {
   //    int width = this.image.getWidth();
   //    int height = this.image.getHeight();
   //    return this.image.getScaledInstance(
   //       (int) (width * scale),
   //       (int) (height * scale),
   //       Image.SCALE_SMOOTH
   //    );
   // }
}
