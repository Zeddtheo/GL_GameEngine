package GraphicEngine;

import Game.Food;
import Game.Head;
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
