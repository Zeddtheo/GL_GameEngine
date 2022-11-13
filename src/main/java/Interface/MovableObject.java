package Interface;

import java.awt.*;

public interface MovableObject extends PhysicalObject {
    void setSpeed(int speed);
    long getSpeed();
    Rectangle getNextStep();
    void goNextStep();
}
