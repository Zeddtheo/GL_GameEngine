package Interface;

import PhysicEngine.Position;

import java.awt.*;

public interface PhysicalObject {
    Position getPos();
    void setPos(Position pos);
    int getWidth();
    int getHeight();
    Rectangle collision();
}