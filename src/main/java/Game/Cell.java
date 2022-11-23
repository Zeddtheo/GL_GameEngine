package Game;

import PhysicEngine.Entity;

/**
 * The type Cell.
 */
public class Cell extends Entity {

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
    }

    @Override
    public String toString() {
        return getPos().toString();
    }
}
