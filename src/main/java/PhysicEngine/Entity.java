package PhysicEngine;

import Interface.GraphicalObject;
import Interface.PhysicalObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The type Entity.
 */
public abstract class Entity implements PhysicalObject, GraphicalObject {
    /**
     * The Hit box.
     */
    protected HitBox hitBox;
    /**
     * The Image.
     */
    protected ImageIcon image;

    /**
     * Instantiates a new Entity.
     *
     * @param x      the x
     * @param y      the y
     * @param width  the width
     * @param height the height
     */
    protected Entity(int x, int y, int width, int height) {
        this.hitBox = new HitBox(x, y, width, height);
    }

    @Override
    public Position getPos() {
        return hitBox.getCorner();
    }

    @Override
    public void setPos(Position pos) {
        this.hitBox.refresh(pos);
    }

    @Override
    public int getWidth() {
        return hitBox.getWidth();
    }

    @Override
    public int getHeight() {
        return hitBox.getHeight();
    }

    @Override
    public Rectangle collision() {
        return new Rectangle((int) hitBox.getCorner().getPosX(), (int) hitBox.getCorner().getPosY(), hitBox.getWidth(), hitBox.getHeight());
    }

    @Override
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public String toString() {
        return getPos().toString();
    }
}
