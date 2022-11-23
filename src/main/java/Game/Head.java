package Game;

import PhysicEngine.MovableEntity;
import PhysicEngine.Vector;

/**
 * The type Head.
 */
public class Head extends MovableEntity {

    /**
     * Instantiates a new Head.
     *
     * @param x      the x of left up corner
     * @param y      the y of left up corner
     * @param width  the width
     * @param height the height
     */
    public Head(int x, int y, int width, int height) {
        super(x, y, width, height);
        V = new Vector(1, 0);
    }

    @Override
    public String toString() {
        return getCoordinate().toString();
    }
}
