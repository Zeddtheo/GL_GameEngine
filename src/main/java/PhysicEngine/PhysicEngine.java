package PhysicEngine;


import java.util.List;

/**
 * The type Physic engine.
 */
public class PhysicEngine {

    /**
     * move element with list of potential collision for check
     *
     * @param movableEntity element to move
     * @param collisions    the collisions
     * @return the boolean apply movement
     */
    public static boolean move(MovableEntity movableEntity, List<Entity> collisions){
        for (Entity collision : collisions) {
            if (movableEntity.getNextStep().intersects(collision.collision())) return false;
        }
        movableEntity.applyMovement();
        return true;
    }

    /**
     * Move.
     *
     * @param movableEntity the movable entity
     */
    public static void move(MovableEntity movableEntity){
        movableEntity.applyMovement();
    }

}
