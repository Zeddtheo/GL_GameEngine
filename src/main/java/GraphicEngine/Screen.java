package GraphicEngine;

import sample.PhysicEngine.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(10, this);
    Player p = new Player(10,10,10,10,0,0);
    public Screen(){
        addKeyListener(this);
        setFocusable(true);

        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
    }

    public void paint(Graphics g){
        g.clearRect(0,0, getWidth(),getHeight());
        p.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                p.setDy(-1);
                break;
            case KeyEvent.VK_DOWN:
                p.setDy(1);
                break;
            case KeyEvent.VK_LEFT:
                p.setDx(-1);
                break;
            case KeyEvent.VK_RIGHT:
                p.setDx(1);
                break;
            case KeyEvent.VK_R:
                p.setDx(0);
                p.setDy(0);
                break;
        }
    }
}
