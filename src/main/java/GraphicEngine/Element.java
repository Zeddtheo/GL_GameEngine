package GraphicEngine;

import PhysicEngine.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The type Element.
 */
public class Element extends JPanel {

    /**
     * The Entity.
     */
    public Entity entity;

    /**
     * Instantiates a new Element.
     *
     * @param entity the entity
     */
    public Element(Entity entity){
        this.entity = entity;
        setBounds(entity.collision());
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {

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
