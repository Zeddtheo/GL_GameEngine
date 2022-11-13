package PhysicEngine;

import Interface.GraphicalObject;
import Interface.PhysicalObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity implements PhysicalObject, GraphicalObject {
    protected HitBox hitBox;
    protected ImageIcon image;

    protected Entity(HitBox hitBox) {
        this.hitBox = hitBox;
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
}
