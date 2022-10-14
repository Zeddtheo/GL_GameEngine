package sample;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * An extension of javax.swing.JFrame that can draw images.
 */
public class MyJavaPanel extends JPanel {

  private BufferedImage image;
  /**
   * Constructs a new panel that draw an image.
   */

  public MyJavaPanel() {
    try {
      image = ImageIO.read(Objects.requireNonNull(getClass().getResource("image.png")));
    } catch (IOException ex) {
      System.out.println("problem! image can't be loaded!");
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 50, 50, null);
  }
}
