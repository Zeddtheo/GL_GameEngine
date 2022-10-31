package sample;

import game.Database;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.Serial;
import javax.swing.JFrame;


/**
 * An extended version of javax.swing.JFrame containing a panel to draw images.
 */
public class MyJavaFrame extends JFrame {

  @Serial
  private static final long serialVersionUID = 42L;
  /**
   * Constructs a new visible frame.
   */


  public MyJavaFrame() {
    setTitle("Main window");
    setSize(400, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(new MyJavaPanel());
    setVisible(true);

    /**
     * Save data when exits.
     */
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.out.println("Detected Closing Window");
        try {
          Database.saveData();
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
        System.exit(0);
      }
    });
  }

  public static void main(String[] args) {
    new MyJavaFrame();
  }


}
