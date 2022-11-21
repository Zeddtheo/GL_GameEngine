package Game;

import PhysicEngine.Entity;
import PhysicEngine.MovableEntity;

import java.util.LinkedList;

public class Snake {
    LinkedList<Entity> body;
    MovableEntity head;
    MovableEntity tail;
    Snake(int x1, int y1, int x2, int y2, int width, int height, LinkedList<Entity> snake) {
        this.body = snake;
        this.head = new Head(x1, y1, width, height);
        this.tail = new Tail(x2, y2, width, height, this);
    }
}
