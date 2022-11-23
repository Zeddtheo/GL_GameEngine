package Game;

/**
 * Save Enemies' information in order to reload.
 */
public class Node {
    private int x;
    private int y;
    private int direction;

    /**
     * Instantiates a new Node.
     *
     * @param x         the x
     * @param y         the y
     * @param direction the direction
     */
    public Node(int x, int y, int direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * Get x int.
     *
     * @return the int
     */
    public int getX(){
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }
}
