package Interface;

import java.awt.*;

public interface PhysicalObject {
    double getPosX();
    double getPosY();
    void setPosX(double posX);
    void setPosY(double posY);
    int getWidth();
    int getHeight();
    void setWidth(int width);
    void setHeight(int height);
    Rectangle collision();
}