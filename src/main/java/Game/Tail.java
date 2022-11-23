package Game;

import PhysicEngine.MovableEntity;
import PhysicEngine.Position;
import PhysicEngine.Vector;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Tail extends MovableEntity {
    Snake snake;
    BufferedImage tailUp;
    BufferedImage tailLeft;
    BufferedImage tailDown;
    BufferedImage tailRight;
    public Tail(int x, int y, int width, int height, Snake snake) {
        super(x, y, width, height);
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("TailEnd.png")));
            tailLeft = image;
            tailUp = rotate(image, 90);
            tailRight = rotate(tailUp, 90);
            tailDown = rotate(tailRight, 90);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.snake = snake;
    }

    @Override
    public void applyMovement() {
        int x = (int) getPos().getPosX();
        int y = (int) getPos().getPosY();
        int lastX = (int) snake.body.getLast().getPos().getPosX();
        int lastY = (int) snake.body.getLast().getPos().getPosY();
        int v = (int) vitesse;
        if (lastX > x) {
            V = new Vector(1, 0);
            setCoordinate(new Position(x + v, y));
        }
        else if (lastX < x) {
            V = new Vector(-1, 0);
            setCoordinate(new Position(x - v, y));

        }
        else if (lastY > y) {
            V = new Vector(0, 1);
            setCoordinate(new Position(x, y + v));
        }
        else if (lastY < y) {
            V = new Vector(0, -1);
            setCoordinate(new Position(x, y - v));
        }
    }

    @Override
    public BufferedImage getImage() {
        if (V.getVx() > 0) return tailRight;
        else if (V.getVx() < 0) return tailLeft;
        else if (V.getVy() > 0) return tailDown;
        else return tailUp;
    }
}
