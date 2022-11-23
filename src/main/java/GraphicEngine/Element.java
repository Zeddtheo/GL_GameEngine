package GraphicEngine;

import PhysicEngine.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Element extends JPanel {

    public Entity entity;
    public Element(Entity entity){
        this.entity = entity;
        setBounds(entity.collision());
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
//        System.out.println(entity);
//        System.out.println(entity.getImage());
//        System.out.println();
        BufferedImage image = entity.getImage();
        if (image == null) {
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        else {
            g.drawImage(image,
                    0,
                    0,
                    entity.getWidth(),
                    entity.getHeight(),
                    null);
        }
    }

    @Override
    public String toString() {
        return entity.toString();
    }
}
