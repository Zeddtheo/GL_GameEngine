package NewGraphicEngine;

import Game.CoreKernel;
import InputEngine.Keyboard;
import PhysicEngine.Entity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Screen extends JPanel {

    CoreKernel coreKernel;

    public List<Element> elements = new ArrayList<>();
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

    public void refresh(CoreKernel coreKernel){
        for (Element element : elements) {
            element.setBounds(element.entity.collision());
        }
        getGraphics().drawLine(400, 0, 400, 400);
        getGraphics().drawLine(0, 400, 400, 400);

    }

}
