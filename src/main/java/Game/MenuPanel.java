package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The type Menu panel.
 */
public class MenuPanel extends JPanel implements KeyListener {
    /**
     * The width and height
     */
    private  int width, height;

    /**
     * Instantiates a new Menu panel.
     *
     * @param width  the width
     * @param height the height
     */
    public MenuPanel(int width, int height){
        this.height = height;
        this.width = width;
        this.setSize(width,height);;
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    /**
     * All buttons menue.
     */
    private String[] menus = new String[]{"START","SETTINGS","ABOUT US","EXIT"};

    /**
     * The focus Index.
     */
    private int focusIndex;

    /**
     * The menu x.
     */
    private int menu_x = 260;

    /**
     * The position of menu's elements.
     */
    private int[] menu_ys = new int[]{80,110,140,170};
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(0x9391d6));
        g.fillRect(0,0,width,height);
        for(int i = 0;i<menus.length;i++){
            int x = menu_x;
            int y = menu_ys[i];
            if(i ==focusIndex){
                g.setColor(Color.RED);
            }else{
                g.setColor(Color.black);
            }
            g.drawString(menus[i],x,y);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                focusIndex = (focusIndex + menus.length - 1) % menus.length;
                this.repaint();
                break;
            case KeyEvent.VK_DOWN:
                focusIndex = (focusIndex+1)%menus.length;
                this.repaint();
                break;
            case KeyEvent.VK_ENTER:
                //rester ajouter
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
