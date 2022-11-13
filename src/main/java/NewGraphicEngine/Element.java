package NewGraphicEngine;

import PhysicEngine.Entity;

import javax.swing.*;
import java.awt.*;

public class Element extends JPanel {

    ImageIcon image;
    Entity entity;
    public Element(Entity entity){
        this.entity = entity;
        this.image = entity.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBounds(entity.collision());
        if (image == null) {
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        else {
            g.drawRect(0, 0, getWidth(), getHeight());
            g.drawImage(image.getImage(),
                    0,
                    0,
                    null);
        }
    }
}
