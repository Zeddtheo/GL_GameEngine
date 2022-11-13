package Game;

import PhysicEngine.Entity;
import PhysicEngine.HitBox;

import javax.swing.*;

public class Wall extends Entity {

    public Wall(HitBox hitBox) {
        super(hitBox);
    }

    @Override
    public ImageIcon getImage() {
        return null;
    }

    @Override
    public void setImage(ImageIcon image) {

    }
}
