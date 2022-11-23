package PhysicEngine;

import java.awt.*;

/**
 * The type Hit box.
 */
public class HitBox {

    private Position corner;
    private final int height; //hauteur

    private final int width; //largeur


    /**
     * Instantiates a new HitBox.
     *
     * @param coordinate left corner coordinate
     * @param width      the width
     * @param height     the height
     */
    public HitBox(Position coordinate, int width, int height) {
        setCornerLeft(coordinate);
        this.width = width;
        this.height = height;
    }

    /**
     * Instantiates a new Hit box.
     *
     * @param x      the x
     * @param y      the y
     * @param width  the width
     * @param height the height
     */
    public HitBox(int x, int y, int width, int height) {
        this(new Position(x, y), width, height);
    }

    private void setCornerLeft(Position position){
        corner = position;
    }

    /**
     * Get rectangle rectangle.
     *
     * @return the rectangle
     */
    public Rectangle getRectangle(){
        return new Rectangle((int) corner.getPosX(), (int) corner.getPosY(), width, height );
    }

    /**
     * actualise la position du coin haut gauche de la hitbox
     *
     * @param position la position du centre de l'objet
     */
    public void refresh(Position position){
        setCornerLeft(position);
    }

    /**
     * Gets corner.
     *
     * @return the corner
     */
    public Position getCorner() {
        return corner;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get down left corner position.
     *
     * @return the position
     */
    public Position getDownLeftCorner(){
        return new Position(corner.getPosX(), corner.getPosY() + height);
    }

    /**
     * Get down right corner position.
     *
     * @return the position
     */
    public Position getDownRightCorner(){
        return new Position(corner.getPosX() + width, corner.getPosY() + height);
    }

    /**
     * Get up right corner position.
     *
     * @return the position
     */
    public Position getUpRightCorner(){
        return new Position(corner.getPosX() + width, corner.getPosY());
    }
}
