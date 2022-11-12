package InputEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard extends Input implements  KeyListener, ActionListener {

    public Keyboard() {
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                super.setGoUp(true);
                break;
            case KeyEvent.VK_DOWN:
                super.setGoDown(true);
                break;
            case KeyEvent.VK_LEFT:
                super.setGoLeft(true);
                break;
            case KeyEvent.VK_RIGHT:
                super.setGoRight(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                super.setGoUp(false);
                break;
            case KeyEvent.VK_DOWN:
                super.setGoDown(false);
                break;
            case KeyEvent.VK_LEFT:
                super.setGoLeft(false);
                break;
            case KeyEvent.VK_RIGHT:
                super.setGoRight(false);
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
