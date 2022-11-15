package Game;

import PhysicEngine.HitBox;
import PhysicEngine.MovableEntity;
import PhysicEngine.Orientation;

import javax.swing.*;

public class MyCharacter extends MovableEntity {
    // change class name to "Pacman" or smth

    public MyCharacter(HitBox hitBox) {
        super(hitBox);
        image = new ImageIcon("Head.png");
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
