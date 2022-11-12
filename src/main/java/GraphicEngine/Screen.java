package GraphicEngine;
import PhysicEngine.Collider.BoxCollider;
import PhysicEngine.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements ActionListener, KeyListener {
    Timer t = new Timer(10, this);
    Player p = new Player(10,10,10,10,0,0);
    Player p2 = new Player(20,20,10,10,0,0);
    public Screen(){
        addKeyListener(this);
        setFocusable(true);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p.move();
        BoxCollider b1 = new BoxCollider(p.x,p.y,p.width);
        p2.move();
        BoxCollider b2 = new BoxCollider(p2.x,p2.y,p2.width);
        if(b1.checkCollision(b2)){
            System.out.println("hit!");
        }
        repaint();
    }

    public void paint(Graphics g){
        g.clearRect(0,0, getWidth(),getHeight());
        p.draw(g);
        //p2.draw(g);
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
            case KeyEvent.VK_W:
                p2.setDy(-1);
                break;
            case KeyEvent.VK_S:
                p2.setDy(1);
                break;
            case KeyEvent.VK_A:
                p2.setDx(-1);
                break;
            case KeyEvent.VK_D:
                p2.setDx(1);
                break;
            case KeyEvent.VK_T:
                p2.setDx(0);
                p2.setDy(0);
                break;
        }
    }
}
