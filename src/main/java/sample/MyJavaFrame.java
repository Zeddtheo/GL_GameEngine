package sample;

import javax.swing.JFrame;

/**
 * An extended version of javax.swing.JFrame containing a panel to draw images.
 */
public class MyJavaFrame extends JFrame {
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
  }

  public static void main(String[] args) {
    new MyJavaFrame();
  }
}
