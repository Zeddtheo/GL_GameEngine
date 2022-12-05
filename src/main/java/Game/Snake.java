package Game;

import PhysicEngine.Entity;

import java.util.LinkedList;

/**
 * The type Snake.
 */
public class Snake {
    /**
     * The Body.
     */
    LinkedList<Entity> body;
    /**
     * The Head.
     */
    Head head;
    /**
     * The Tail.
     */
    Tail tail;

    /**
     * Instantiates a new Snake.
     *
     * @param x1     the x 1
     * @param y1     the y 1
     * @param x2     the x 2
     * @param y2     the y 2
     * @param width  the width
     * @param height the height
     * @param snake  the snake
     */
    Snake(int x1, int y1, int x2, int y2, int width, int height, LinkedList<Entity> snake) {
        this.body = snake;
        this.head = new Head(x1, y1, width, height);
        this.tail = new Tail(x2, y2, width, height, this);
    }
}
