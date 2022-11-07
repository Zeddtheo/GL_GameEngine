package sample.newPhysicEngine;

import sample.PhysicEngine.Position;

public class PhysicEngine {

    /**
     * faire bouger les elements
     * @param moovableElement
     * @param vector
     */
    public static void move(MoovableElement moovableElement, Vector vector){
        moovableElement.setCoordinate(new Position(moovableElement.getCoordinate().getPosX() + vector.getVx(),moovableElement.getCoordinate().getPosY() + vector.getVy()));
    }

    /**
     * Savoir si les 2 hitbox sont en collision
     * @param hitBox1 hitbox1
     * @param hitBox2 hitbox2
     * @return si oui ou non c'est en collision
     */
    public static boolean isCollision(HitBox hitBox1, HitBox hitBox2){
        return false;
    }
}
