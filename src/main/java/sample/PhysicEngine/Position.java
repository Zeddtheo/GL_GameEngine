package sample.PhysicEngine;

public class Position {
    private long posX;
    private long posY;

    public Position(long posX, long posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public long getPosX() {
        return posX;
    }

    public void setPosX(long posX) {
        this.posX = posX;
    }

    public long getPosY() {
        return posY;
    }

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
