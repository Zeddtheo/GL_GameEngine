package Game;

import PhysicEngine.MovableEntity;
import PhysicEngine.Position;

import java.awt.*;

/**
 * The type Tail.
 */
public class Tail extends MovableEntity {
    /**
     * The Snake.
     */
    Snake snake;

    /**
     * Instantiates a new Tail.
     *
     * @param x      the x
     * @param y      the y
     * @param width  the width
     * @param height the height
     * @param snake  the snake
     */
    public Tail(int x, int y, int width, int height, Snake snake) {
        super(x, y, width, height);
        this.snake = snake;
    }

    @Override
    public Rectangle getNextStep() {
        int x = (int) getPos().getPosX();
        int y = (int) getPos().getPosY();
        int lastX = (int) snake.body.getLast().getPos().getPosX();
        int lastY = (int) snake.body.getLast().getPos().getPosY();
        int v = (int) vitesse;
        if (lastX > x) {
            return new Rectangle(x + v, y, getWidth(), getHeight());
        }
        if (lastX < x) {
            return new Rectangle(x - v, y, getWidth(), getHeight());
        }
        if (lastY > y) {
            return new Rectangle(x, y + v, getWidth(), getHeight());
        }
        if (lastY < y) {
            return new Rectangle(x, y - v, getWidth(), getHeight());
        }
        return hitBox.getRectangle();
    }

    @Override
    public void applyMovement() {
        int x = (int) getPos().getPosX();
        int y = (int) getPos().getPosY();
        int lastX = (int) snake.body.getLast().getPos().getPosX();
        int lastY = (int) snake.body.getLast().getPos().getPosY();
        int v = (int) vitesse;
        if (lastX > x) {
            setCoordinate(new Position(x + v, y));
        }
        else if (lastX < x) {
            setCoordinate(new Position(x - v, y));

        }
        else if (lastY > y) {
            setCoordinate(new Position(x, y + v));
        }
        else if (lastY < y) {
            setCoordinate(new Position(x, y - v));
        }
    }

    @Override
    public String toString() {
        return getCoordinate().toString();
    }
}
