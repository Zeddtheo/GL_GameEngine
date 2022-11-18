package PhysicEngine;


import java.util.List;

public class PhysicEngine {

    /**
     * faire bouger les elements
     *
     * @param movableEntity l'element que l'on veut faire bouger
     * @return si le mouvement a pu etre effectué
     */
    public static boolean move(MovableEntity movableEntity, List<Entity> collisions){
        for (Entity collision : collisions) {
            //si il y a collision avec un mur
            if (isCollision(movableEntity, collision)) return false;
            //si il n'est pas dans un couloir
        }
        movableEntity.applyMovement();
        return true;
    }

    /**
     * Savoir si les 2 hitbox sont en collision
     * @param entity hitbox1
     * @param entity2 hitbox2
     * @return si oui ou non il y a une collision
     */
    public static boolean isCollision(MovableEntity entity, Entity entity2){
        return entity.getNextStep().intersects(entity2.collision());

    }
}
