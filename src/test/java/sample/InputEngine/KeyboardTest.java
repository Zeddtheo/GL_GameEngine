package sample.InputEngine;

import Game.CoreKernel;
import InputEngine.Keyboard;
import org.junit.jupiter.api.Test;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeyboardTest{

    @Test
    public void KeyboardTests() {
        CoreKernel coreKernel = new CoreKernel();
        Keyboard keyboard = new Keyboard(coreKernel);
        Keyboard keyboard1 = new Keyboard(coreKernel);
        Keyboard keyboard2 = new Keyboard(coreKernel);
        Keyboard keyboard3 = new Keyboard(coreKernel);

        KeyEvent key = new KeyEvent(keyboard, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_UP,'Z');
        keyboard.keyPressed(key);
        assertTrue(keyboard.isGoUp());

        KeyEvent key1 = new KeyEvent(keyboard, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_DOWN,'S');
        keyboard1.keyPressed(key1);
        assertTrue(keyboard1.isGoDown());

        KeyEvent key2 = new KeyEvent(keyboard, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_LEFT,'Q');
        keyboard2.keyPressed(key2);
        assertTrue(keyboard2.isGoLeft());

        KeyEvent key3 = new KeyEvent(keyboard, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_RIGHT,'D');
        keyboard3.keyPressed(key3);
        assertTrue(keyboard3.isGoRight());
    }
}

