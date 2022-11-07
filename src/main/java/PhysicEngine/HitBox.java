package PhysicEngine;

public class HitBox {

    private Position corner;
    private final int height; //hauteur

    private final int lenght; //largeur


    /**
     * Prend la coordonnée du centre de l'element et la longueur souhaité pour creer la hitbox
     * @param coordinate le centre de l'element
     * @param lenght la longueur de l'element
     */
    public HitBox(Position coordinate, int lenght, int height) {
        setCornerLeft(coordinate);
        this.lenght = lenght;
        this.height = height;
    }

    private void setCornerLeft(Position position){
        corner = new Position(position.getPosX() - lenght/2, position.getPosY() - height/2);
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

    public int getLenght() {
        return lenght;
    }

    public Position getDownLeftCorner(){
        return new Position(corner.getPosX(), corner.getPosY() + height);
    }

    public Position getDownRightCorner(){
        return new Position(corner.getPosX() + lenght, corner.getPosY() + height);
    }

    public Position getUpRightCorner(){
        return new Position(corner.getPosX() + lenght, corner.getPosY());
    }
}
