package PhysicEngine;

import java.awt.*;

public class HitBox {

    private Position corner;
    private final int height; //hauteur

    private final int width; //largeur


    /**
     * Prend la coordonnée du centre de l'element et la longueur souhaité pour creer la hitbox
     * @param coordinate le centre de l'element
     * @param width la longueur de l'element
     */
    public HitBox(Position coordinate, int width, int height) {
        setCornerLeft(coordinate);
        this.width = width;
        this.height = height;
    }

    public HitBox(int x, int y, int width, int height) {
        this(new Position(x, y), width, height);
    }

    private void setCornerLeft(Position position){
        corner = position;
    }

    public Rectangle getRectangle(){
        return new Rectangle((int) corner.getPosX(), (int) corner.getPosY(), width, height );
    }

    /**
     * actualise la position du coin haut gauche de la hitbox
     * @param position la position du centre de l'objet
     */
    public void refresh(Position position){
        setCornerLeft(position);
    }

    public Position getCorner() {
        return corner;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Position getDownLeftCorner(){
        return new Position(corner.getPosX(), corner.getPosY() + height);
    }

    public Position getDownRightCorner(){
        return new Position(corner.getPosX() + width, corner.getPosY() + height);
    }

    public Position getUpRightCorner(){
        return new Position(corner.getPosX() + width, corner.getPosY());
    }
}
