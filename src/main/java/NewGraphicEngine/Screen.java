package NewGraphicEngine;

import Game.CoreKernel;
import InputEngine.Keyboard;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Screen extends JPanel {

    CoreKernel coreKernel;
    Element player = new Element(new ImageIcon("Player.png"));

    Timer t ;
    public Screen(Keyboard keyboard, CoreKernel coreKernel){
        t = new Timer(10, keyboard);

        addKeyListener(keyboard);
        setFocusable(true);
        this.coreKernel = coreKernel;
        setVisible(true);


        player.setVisible(true);
        player.setBounds(coreKernel.player.getHitBox().getRectangle());

        player.setVisible(true);
        add(player);
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(getGraphics());
        player.paintComponent(getGraphics());
    }

    public void refresh(CoreKernel coreKernel){
        player.setBounds(coreKernel.player.getHitBox().getRectangle());

    }

}
