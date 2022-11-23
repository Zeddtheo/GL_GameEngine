package PhysicEngine;


import java.util.List;

public class PhysicEngine {

    /**
     * faire bouger les elements
     * @param movableEntity l'element que l'on veut faire bouger
     */
    public static boolean move(MovableEntity movableEntity, List<Entity> collisions){
        for (Entity collision : collisions) {
            if (movableEntity.getNextStep().intersects(collision.collision())) return false;
        }
        movableEntity.applyMovement();
        return true;
    }

    public static void move(MovableEntity movableEntity){
        movableEntity.applyMovement();
    }

}
