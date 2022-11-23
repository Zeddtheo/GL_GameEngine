package Game;

import PhysicEngine.Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Cell extends Entity {
    Entity previous;
    Entity next;


    BufferedImage upRight;
    BufferedImage upDown;
    BufferedImage upLeft;
    BufferedImage rightDown;
    BufferedImage rightLeft;
    BufferedImage downLeft;

    protected Cell(int x, int y, int width, int height) {
        super(x, y, width, height);
        img();
    }

    protected Cell(Entity entity) {
        super((int) entity.getPos().getPosX(),
                (int) entity.getPos().getPosY(),
                entity.getWidth(),
                entity.getHeight());
        img();
    }

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

    public void setPrevious(Entity previous) {
        this.previous = previous;
    }

    public void setNext(Entity next) {
        this.next = next;
    }

    public Entity getPrevious() {
        return previous;
    }

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
