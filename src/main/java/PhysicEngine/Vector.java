package PhysicEngine;

/**
 * The type Vector.
 */
public class Vector {

    private long Vx;
    private long Vy;

    /**
     * Instantiates a new Vector.
     *
     * @param vx the vx
     * @param vy the vy
     */
    public Vector(long vx, long vy) {
        Vx = vx;
        Vy = vy;
    }

    /**
     * Gets vx.
     *
     * @return the vx
     */
    public long getVx() {
        return Vx;
    }

    /**
     * Gets vy.
     *
     * @return the vy
     */
    public long getVy() {
        return Vy;
    }

    /**
     * Is oposite boolean.
     *
     * @param vector the vector
     * @return the boolean
     */
    public boolean isOposite(Vector vector){
        return getVx() + vector.getVx() == 0 && getVy() + vector.getVy() == 0;
    }

    /**
     * Is on abssice boolean.
     *
     * @return the boolean
     */
    public boolean isOnAbssice(){
        return Vx != 0;
    }


}
