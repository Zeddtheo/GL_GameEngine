package sample.newPhysicEngine;

import sample.PhysicEngine.Position;

public class HitBox {

    private Position cornerleftUp;
    private int length;

    /**
     * Prend la coordonnée du centre de l'element et la longueur souhaité pour creer la hitbox
     * @param coordinate le centre de l'element
     * @param length la longueur de l'element
     */
    public HitBox(Position coordinate, int length) {
        setCornerLeft(coordinate);
        this.length = length;
    }

    private void setCornerLeft(Position position){
        cornerleftUp = new Position(position.getPosX() - length/2, position.getPosY() - length/2);
    }

    /**
     * actualise la position du coin haut gauche de la hitbox
     * @param position la position du centre de l'objet
     */
    public void refresh(Position position){
        setCornerLeft(position);
    }


}
