package NewGraphicEngine;

import Game.Food;
import Game.Head;
import PhysicEngine.Entity;

import javax.swing.*;
import java.awt.*;

/**
 * The type Element.
 */
public class Element extends JPanel {

    /**
     * The Image.
     */
    ImageIcon image;
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
        this.image = entity.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBounds(entity.collision());
        if (image == null) {
            if (entity instanceof Food) {
                g.setColor(Color.RED);
            }
            else if (entity instanceof Head) {
                g.setColor(Color.YELLOW);
            }
            else g.setColor(Color.GREEN);
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

    @Override
    public String toString() {
        return entity.toString();
    }
}
