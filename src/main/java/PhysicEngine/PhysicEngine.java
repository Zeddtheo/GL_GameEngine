package PhysicEngine;


public class PhysicEngine {

    /**
     * faire bouger les elements
     * @param movableElement l'element que l'on veut faire bouger
     */
    public static void move(MovableElement movableElement){
        movableElement.applyMovement();
    }

    /**
     * Savoir si les 2 hitbox sont en collision
     * @param hitBox1 hitbox1
     * @param hitBox2 hitbox2
     * @return si oui ou non il y a une collision
     */
    public static boolean isCollision(HitBox hitBox1, HitBox hitBox2){

        if(hitBox1.getCorner().getPosX() <= (hitBox2.getCorner().getPosX() + hitBox2.getWidth()) &&
                hitBox1.getCorner().getPosY() <= (hitBox2.getCorner().getPosY() + hitBox2.getHeight()) &&
                hitBox1.getCorner().getPosX() >= (hitBox2.getCorner().getPosX()) &&
                hitBox1.getCorner().getPosY() >= (hitBox2.getCorner().getPosY())){
            return true;
        }
        if(hitBox1.getUpRightCorner().getPosX() <= (hitBox2.getCorner().getPosX() + hitBox2.getWidth()) &&
                hitBox1.getUpRightCorner().getPosY() <= (hitBox2.getCorner().getPosY() + hitBox2.getHeight()) &&
                hitBox1.getUpRightCorner().getPosX() >= (hitBox2.getCorner().getPosX()) &&
                hitBox1.getUpRightCorner().getPosY() >= (hitBox2.getCorner().getPosY())){
            return true;
        }
        if(hitBox1.getDownLeftCorner().getPosX() <= (hitBox2.getCorner().getPosX() + hitBox2.getWidth()) &&
                hitBox1.getDownLeftCorner().getPosY() <= (hitBox2.getCorner().getPosY() + hitBox2.getHeight()) &&
                hitBox1.getDownLeftCorner().getPosX() >= (hitBox2.getCorner().getPosX()) &&
                hitBox1.getDownLeftCorner().getPosY() >= (hitBox2.getCorner().getPosY())){
            return true;
        }
        if(hitBox1.getDownRightCorner().getPosX() <= (hitBox2.getCorner().getPosX() + hitBox2.getWidth()) &&
                hitBox1.getDownRightCorner().getPosY() <= (hitBox2.getCorner().getPosY() + hitBox2.getHeight()) &&
                hitBox1.getDownRightCorner().getPosX() >= (hitBox2.getCorner().getPosX()) &&
                hitBox1.getDownRightCorner().getPosY() >= (hitBox2.getCorner().getPosY())){
            return true;
        }
        return false;
    }
}
