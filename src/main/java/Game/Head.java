package Game;

import PhysicEngine.MovableEntity;
import PhysicEngine.Vector;

public class Head extends MovableEntity {

    public Head(int x, int y, int width, int height) {
        super(x, y, width, height);
        V = new Vector(1, 0);
    }

    @Override
    public String toString() {
        return getCoordinate().toString();
    }
}
