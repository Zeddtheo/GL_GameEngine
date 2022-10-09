package sample;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class MyJPanel extends JPanel {

  private BufferedImage image;

  public MyJPanel() {
    try {
      image = ImageIO.read(getClass().getResource("image.png"));
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
