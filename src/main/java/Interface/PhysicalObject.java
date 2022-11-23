package Interface;

import PhysicEngine.Position;

import java.awt.*;

/**
 * The interface Physical object.
 */
public interface PhysicalObject {
    /**
     * Gets pos.
     *
     * @return the pos
     */
    Position getPos();

    /**
     * Sets pos.
     *
     * @param pos the pos
     */
    void setPos(Position pos);

    /**
     * Gets width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Gets height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Collision rectangle.
     *
     * @return the rectangle
     */
    Rectangle collision();
}