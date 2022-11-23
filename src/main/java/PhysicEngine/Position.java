package PhysicEngine;

/**
 * The type Position.
 */
public class Position {
    private long posX;
    private long posY;

    /**
     * Instantiates a new Position.
     *
     * @param posX the pos x
     * @param posY the pos y
     */
    public Position(long posX, long posY) {
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * Gets pos x.
     *
     * @return the pos x
     */
    public long getPosX() {
        return posX;
    }

    /**
     * Sets pos x.
     *
     * @param posX the pos x
     */
    public void setPosX(long posX) {
        this.posX = posX;
    }

    /**
     * Gets pos y.
     *
     * @return the pos y
     */
    public long getPosY() {
        return posY;
    }

    /**
     * Sets pos y.
     *
     * @param posY the pos y
     */
    public void setPosY(long posY) {
        this.posY = posY;
    }

    @Override
    public String toString() {
        return "Position{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
