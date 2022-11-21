package GraphicEngine;

import Game.CoreKernel;
import InputEngine.Keyboard;
import PhysicEngine.Entity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Screen extends JPanel {

    CoreKernel coreKernel;

    List<Element> elements = new ArrayList<>();
    public Screen(Keyboard keyboard, CoreKernel coreKernel){

        for (Entity entity : coreKernel.entities) {
            Element element = new Element(entity);
            elements.add(element);
            element.setBounds(element.entity.collision());
            element.setVisible(true);
            add(element);
        }

        addKeyListener(keyboard);
        setFocusable(true);
        this.coreKernel = coreKernel;
        setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(getGraphics());
        //player.paintComponent(getGraphics());
    }

    public void refresh(CoreKernel coreKernel){
        for (Element element : elements) {
            element.setBounds(element.entity.collision());
            element.repaint();
        }

    }

}
