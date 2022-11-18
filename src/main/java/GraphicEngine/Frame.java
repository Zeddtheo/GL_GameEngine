package GraphicEngine;

import Game.CoreKernel;
import Game.MenuPanel;
import InputEngine.Keyboard;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    Screen screen;

    CoreKernel coreKernel;
    public Frame(CoreKernel coreKernel){
        //MenuPanel panel = new MenuPanel(1200,800);
        //getContentPane().add(panel, "Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Player Move");
        setSize(800,600);
        setResizable(false);
        this.coreKernel = coreKernel;
        init();
    }

    public void init(){

        setLayout(new GridLayout(1,1,0,0));

        screen = new Screen((Keyboard) coreKernel.inputTreatment.getInput(), coreKernel);

        add(screen);

        setVisible(true);

        screen.paintComponent(getGraphics());
    }

    public void refresh(){
        screen.refresh(coreKernel);
    }

}
