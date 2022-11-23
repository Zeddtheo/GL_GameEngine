package PhysicEngine;

import Interface.GraphicalObject;
import Interface.PhysicalObject;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public abstract class Entity implements PhysicalObject, GraphicalObject {
    protected HitBox hitBox;
    protected BufferedImage image;

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
    public void setImage(BufferedImage image) {
        this.image = image;
    }


    public BufferedImage rotate(BufferedImage image, int degree) {
        final double rads = Math.toRadians(degree);
        final double sin = Math.abs(Math.sin(rads));
        final double cos = Math.abs(Math.cos(rads));
        final int w = (int) Math.floor(image.getWidth() * cos + image.getHeight() * sin);
        final int h = (int) Math.floor(image.getHeight() * cos + image.getWidth() * sin);
        final BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
        final AffineTransform at = new AffineTransform();
        at.translate(w / 2, h / 2);
        at.rotate(rads,0, 0);
        at.translate(-image.getWidth() / 2, -image.getHeight() / 2);
        final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        rotateOp.filter(image,rotatedImage);
        return rotatedImage;
    }

    public BufferedImage flip(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -image.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(image, null);
    }
}
