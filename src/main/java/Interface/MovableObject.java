package Interface;

import java.awt.*;

/**
 * The interface Movable object.
 */
public interface MovableObject extends PhysicalObject {
    /**
     * Sets speed.
     *
     * @param speed the speed
     */
    void setSpeed(int speed);

    /**
     * Gets speed.
     *
     * @return the speed
     */
    long getSpeed();

    /**
     * Gets next step.
     *
     * @return the next step
     */
    Rectangle getNextStep();

    /**
     * Go next step.
     */
    void goNextStep();
}
