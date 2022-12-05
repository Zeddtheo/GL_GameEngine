package Game;

import PhysicEngine.Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * The type Cell.
 */
public class Cell extends Entity {
    /**
     * The Previous.
     */
    Entity previous;
    /**
     * The Next.
     */
    Entity next;


    /**
     * The Up right.
     */
    BufferedImage upRight;
    /**
     * The Up down.
     */
    BufferedImage upDown;
    /**
     * The Up left.
     */
    BufferedImage upLeft;
    /**
     * The Right down.
     */
    BufferedImage rightDown;
    /**
     * The Right left.
     */
    BufferedImage rightLeft;
    /**
     * The Down left.
     */
    BufferedImage downLeft;

    /**
     * Instantiates a new Cell.
     *
     * @param x      the x
     * @param y      the y
     * @param width  the width
     * @param height the height
     */
    protected Cell(int x, int y, int width, int height) {
        super(x, y, width, height);
        img();
    }

    /**
     * Instantiates a new Cell.
     *
     * @param entity the entity
     */
    protected Cell(Entity entity) {
        super((int) entity.getPos().getPosX(),
                (int) entity.getPos().getPosY(),
                entity.getWidth(),
                entity.getHeight());
        img();
    }

    /**
     * Img.
     */
    void img() {
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("Tail.png")));
            rightLeft = image;
            upDown = rotate(image, 90);
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("TailTurn.png")));
            downLeft = image;
            upLeft = rotate(image, 90);
            upRight = rotate(upLeft, 90);
            rightDown = rotate(upRight, 90);

        } catch (IOException ignored) {
        }
    }

    /**
     * Sets previous.
     *
     * @param previous the previous
     */
    public void setPrevious(Entity previous) {
        this.previous = previous;
    }

    /**
     * Sets next.
     *
     * @param next the next
     */
    public void setNext(Entity next) {
        this.next = next;
    }

    /**
     * Gets previous.
     *
     * @return the previous
     */
    public Entity getPrevious() {
        return previous;
    }

    /**
     * Gets next.
     *
     * @return the next
     */
    public Entity getNext() {
        return next;
    }

    @Override
    public BufferedImage getImage() {
        Entity previous = getPrevious();
        Entity next = getNext();
        if (collision().contains(previous.collision())) return new BufferedImage(getWidth(), getHeight(), image.getType());
        boolean up = false, down = false, left = false, right = false;
        if (getPos().getPosY() > previous.getPos().getPosY()) {
            up = true;
        }
        else if (getPos().getPosX() < previous.getPos().getPosX()) {
            right = true;
        }
        else if (getPos().getPosY() < previous.getPos().getPosY()) {
            down = true;
        }
        else {
            left = true;
        }

        if (getPos().getPosY() > next.getPos().getPosY()) {
            up = true;
        }
        else if (getPos().getPosX() < next.getPos().getPosX()) {
            right = true;
        }
        else if (getPos().getPosY() < next.getPos().getPosY()) {
            down = true;
        }
        else {
            left = true;
        }
        if(up&&right) return upRight;
        if(up&&down) return upDown;
        if(up&&left) return upLeft;
        if(right&&down) return rightDown;
        if(right&&left) return rightLeft;
        return downLeft;
    }
}
