package sample;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serial;
import java.text.MessageFormat;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Game.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * An extension of javax.swing.JFrame that can draw images.
 */
public class MyJavaPanel extends JPanel {
  @Serial
  private static final long serialVersionUID = 4242L;
  private transient BufferedImage image;

  /**
   * Constructs a new panel that draw an image.
   */

  public MyJavaPanel() {
    //Database.reload();
    //Database.setEnemy();
    Logger logger = LogManager.getLogger(this.getClass());
    logger.debug("Construct a MyJavaPanel");
    String path = "image.png";
    if (logger.isDebugEnabled()) {
      String message = MessageFormat.format("Loading image at path {0}", path);
      logger.debug(message);

    }
    try {
      image = ImageIO.read(Objects.requireNonNull(getClass().getResource(path)));
    } catch (Exception ex) {
      String message = MessageFormat.format("Error: Cannot load image at path: {0}", path);
      logger.error(message, ex);
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 50, 50, null);
  }

  /**
   * Present the scoreboard
   * @param g
   */
  public void showInfo(Graphics g){
    g.setColor(Color.BLACK);
    Font font = new Font("Consolas",Font.BOLD,25);
    g.setFont(font);
    //situation remains to modify
    g.drawString("Score: ",1000,1000);
    g.setColor(Color.BLACK);
    g.drawString(Database.getPlayerScore()+"",1020,1020);
  }
}
