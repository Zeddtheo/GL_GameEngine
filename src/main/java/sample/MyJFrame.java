package sample;

import javax.swing.*;
//import java.awt.*;

public class MyJFrame extends JFrame{
  public MyJFrame(){
    setTitle("Main window");
    setSize(400, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(new MyJPanel());
    setVisible(true);
  }

  public static void main(String[] args) {
    MyJFrame app = new MyJFrame();
  }
}
