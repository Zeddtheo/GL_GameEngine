package PhysicEngine;

/**
 * The type Orientation.
 */
public class Orientation {

    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;


    /**
     * Instantiates a new Orientation.
     *
     * @param up    the up
     * @param down  the down
     * @param left  the left
     * @param right the right
     */
    public Orientation(boolean up, boolean down, boolean left, boolean right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    /**
     * Get direction string.
     *
     * @return the string
     */
    public String getDirection(){
        if(up) {return "up";}
        else if(down) {return "down";}
        else if(left) {return "left";}
        else {return "right";}
    }

    /**
     * Clear direction.
     */
    public void clearDirection(){
        up = false;
        down = false;
        left = false;
        right = false;
    }

    /**
     * Face up.
     */
    public void faceUp(){
        clearDirection();
        up = true;
    }

    /**
     * Face down.
     */
    public void faceDown(){
        clearDirection();
        down = true;
    }

    /**
     * Face left.
     */
    public void faceLeft(){
        clearDirection();
        left = true;
    }

    /**
     * Face right.
     */
    public void faceRight(){
        clearDirection();
        right = true;
    }



}
