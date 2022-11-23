package NewGraphicEngine;

import Game.CoreKernel;
import InputEngine.Keyboard;

import javax.swing.*;
import java.awt.*;

/**
 * The type Frame.
 */
public class Frame extends JFrame {

    /**
     * The Screen.
     */
    public Screen screen;

    /**
     * The Core kernel.
     */
    CoreKernel coreKernel;

    /**
     * Instantiates a new Frame.
     *
     * @param coreKernel the core kernel
     */
    public Frame(CoreKernel coreKernel){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Snake");
        setSize(400,430);
        setResizable(false);
        this.coreKernel = coreKernel;
    }

    /**
     * Init.
     */
    public void init(){

        setLayout(new BorderLayout());

        screen = new Screen((Keyboard) coreKernel.inputTreatment.getInput(), coreKernel);

        add(screen);

        setVisible(true);
    }

    /**
     * Refresh.
     */
    public void refresh(){
        screen.refresh();
    }

}
