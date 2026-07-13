package hei.prog.app.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ImageProcessingService {

  public InputStream convertToGrayscale(InputStream inputStream) throws IOException {
    BufferedImage originalImage = ImageIO.read(inputStream);
    if (originalImage == null) {
      throw new IOException("Unable to read image");
    }

    int width = originalImage.getWidth();
    int height = originalImage.getHeight();
    BufferedImage grayscaleImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int rgb = originalImage.getRGB(x, y);
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;

        int gray = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
        int grayRgb = (gray << 16) | (gray << 8) | gray;
        grayscaleImage.setRGB(x, y, grayRgb);
      }
    }

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(grayscaleImage, "png", baos);
    log.info("Image converted to grayscale ({}x{})", width, height);
    return new ByteArrayInputStream(baos.toByteArray());
  }
}
