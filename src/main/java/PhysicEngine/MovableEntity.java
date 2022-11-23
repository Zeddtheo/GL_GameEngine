package PhysicEngine;

import InputEngine.Input;
import Interface.MovableObject;

import java.awt.*;

/**
 * The type Movable entity.
 */
public abstract class MovableEntity extends Entity implements MovableObject {
    /**
     * The V.
     */
    protected Vector V;
    /**
     * The Vitesse.
     */
    protected long vitesse;

    /**
     * Instantiates a new Movable entity.
     *
     * @param x      the x
     * @param y      the y
     * @param width  the width
     * @param height the height
     */
    public MovableEntity(int x, int y, int width, int height) {
        super(x, y, width, height);
        vitesse = 5;
        this.V = new Vector(0,0);
    }

    /**
     * Set coordinate.
     *
     * @param position the position
     */
    public void setCoordinate(Position position){
        hitBox.refresh(position);
    }

    /**
     * Gets coordinate.
     *
     * @return the coordinate
     */
    public Position getCoordinate() {
        return hitBox.getCorner();
    }

    /**
     * Gets hit box.
     *
     * @return the hit box
     */
    public HitBox getHitBox() {
        return hitBox;
    }

    /**
     * Set vitesse.
     *
     * @param goUp    the go up
     * @param goDown  the go down
     * @param goRight the go right
     * @param goLeft  the go left
     */
    public void setVitesse(boolean goUp, boolean goDown, boolean goRight, boolean goLeft ){
        if ((goUp && goDown) || (goLeft && goRight)) return;

        int x = 0, y = 0;
        if (goUp){
            y-=1;
        }
        if (goDown){
            y+=1;
        }
        if (goLeft){
            x-=1;
        }
        if (goRight){
            x+=1;
        }

        double l = Math.sqrt((double) x * x + y * y);
        int x1 = (int) ((double) vitesse * x / l);
        int y1 = (int) ((double) vitesse * y / l);
        V = new Vector(x1, y1);
    }

    /**
     * Apply movement.
     */
    public void applyMovement() {
        //coordinate = coordinate + vitesse;
        long vx = V.getVx();
        long vy = V.getVy();
        int x = (int) hitBox.getCorner().getPosX();
        int y = (int) hitBox.getCorner().getPosY();
        if (vx == 0 && vy == 0) return;
        setCoordinate(new Position(x + V.getVx(),y + V.getVy()));
    }

    /**
     * Sets vitesse.
     *
     * @param input the input
     */
    public void setVitesse(Input input) {
        setVitesse(input.isGoUp(), input.isGoDown(), input.isGoRight(), input.isGoLeft());
    }

    @Override
    public void setSpeed(int speed) {
        vitesse = speed;
    }

    @Override
    public long getSpeed() {
        return vitesse;
    }

    @Override
    public Rectangle getNextStep() {
        long vx = V.getVx();
        long vy = V.getVy();
        int x = (int) hitBox.getCorner().getPosX();
        int y = (int) hitBox.getCorner().getPosY();
        if (vx == 0 && vy == 0) return new  Rectangle(x, y, getWidth(), getHeight());

        return new Rectangle((int) (vx + x), (int) (vy + y), getWidth(), getHeight());
    }

    @Override
    public void goNextStep() {
        applyMovement();
    }
}
