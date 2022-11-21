package Game;

import PhysicEngine.Entity;

public class Cell extends Entity {

    protected Cell(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    protected Cell(Entity entity) {
        super((int) entity.getPos().getPosX(),
                (int) entity.getPos().getPosY(),
                entity.getWidth(),
                entity.getHeight());
    }

    @Override
    public String toString() {
        return getPos().toString();
    }
}
