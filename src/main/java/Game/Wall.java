package Game;

import PhysicEngine.Entity;

import javax.swing.*;

/**
 * The type Wall.
 */
public class Wall extends Entity {

    /**
     * Instantiates a new Wall.
     *
     * @param x      the x
     * @param y      the y
     * @param width  the width
     * @param height the height
     */
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
