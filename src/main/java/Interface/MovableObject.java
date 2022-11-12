package Interface;

import java.awt.*;

public interface MovableObject extends PhysicalObject {
    Vector getVelocityVector();
    void setSpeed(int speed);
    int getSpeed();
    Rectangle getNextStep();
    void goNextStep();
}
