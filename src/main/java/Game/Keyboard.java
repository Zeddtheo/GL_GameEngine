package Game;

import InputEngine.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The type Keyboard.
 */
public class Keyboard extends Input implements KeyListener {

    /**
     * The game
     */
    private final CoreKernel game;
    /**
     * The Restart.
     */
    public boolean restart = false;

    /**
     * Instantiates a new Keyboard.
     *
     * @param game the game
     */
    public Keyboard(CoreKernel game) {
        this.game = game;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (isGoDown()) return;
                super.setGoUp(true);
                break;
            case KeyEvent.VK_DOWN:
                if (isGoUp()) return;
                super.setGoDown(true);
                break;
            case KeyEvent.VK_LEFT:
                if (isGoRight()) return;
                super.setGoLeft(true);
                break;
            case KeyEvent.VK_RIGHT:
                if (isGoLeft()) return;
                super.setGoRight(true);
                break;
            case KeyEvent.VK_R:
                restart = true;
                game.playing = false;
                super.setGoRight(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        switch(e.getKeyCode()) {
//            case KeyEvent.VK_UP:
//                super.setGoUp(false);
//                break;
//            case KeyEvent.VK_DOWN:
//                super.setGoDown(false);
//                break;
//            case KeyEvent.VK_LEFT:
//                super.setGoLeft(false);
//                break;
//            case KeyEvent.VK_RIGHT:
//                super.setGoRight(false);
//                break;
//        }
    }

    /**
     * Gets restart.
     *
     * @return the restart
     */
    public boolean getRestart() {
        if (restart) {
            restart = false;
            return true;
        }
        return false;
    }
}
