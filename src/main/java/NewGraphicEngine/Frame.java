package NewGraphicEngine;

import Game.CoreKernel;
import InputEngine.Keyboard;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Screen screen;

    CoreKernel coreKernel;
    public Frame(CoreKernel coreKernel){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Player Move");
        setSize(400,430);
        setResizable(false);
        this.coreKernel = coreKernel;
    }

    public void init(){

        // setLayout(new GridLayout(1,1,0,0));
        setLayout(new BorderLayout());

        screen = new Screen((Keyboard) coreKernel.inputTreatment.getInput(), coreKernel);


        add(screen);

        setVisible(true);

        // screen.paintComponent(getGraphics());
    }

    public void refresh(){
        screen.refresh(coreKernel);
    }

}
