package Game;

import PhysicEngine.HitBox;
import PhysicEngine.MovableEntity;

import javax.swing.*;

public class MyCharacter extends MovableEntity {
    // change class name to "Pacman" or smth

    public MyCharacter(HitBox hitBox) {
        super((int) hitBox.getCorner().getPosX(),
                (int) hitBox.getCorner().getPosY(),
                hitBox.getWidth(),
                hitBox.getHeight());
        image = new ImageIcon("Player.png");
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
