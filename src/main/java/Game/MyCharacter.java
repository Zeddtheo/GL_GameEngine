package Game;

import PhysicEngine.HitBox;
import PhysicEngine.MovableEntity;

import javax.swing.*;

/**
 * The type My character.
 */
public class MyCharacter extends MovableEntity {

    /**
     * Instantiates a new My character.
     *
     * @param hitBox the hit box
     */
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
