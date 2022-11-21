package Game;

import PhysicEngine.Entity;
import PhysicEngine.HitBox;

import javax.swing.*;

public class Wall extends Entity {

    public Wall(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public ImageIcon getImage() {
        return null;
    }

    @Override
    public void setImage(ImageIcon image) {

    }
}
