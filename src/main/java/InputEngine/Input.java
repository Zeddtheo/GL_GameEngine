package InputEngine;

import java.awt.*;

/**
 * The type Input.
 */
public abstract class Input extends Frame {
    /**
     * The Go right.
     */
    public boolean goRight;

    /**
     * The Go up.
     */
    private boolean goUp;

    /**
     * The Go left.
     */
    private boolean goLeft;

    /**
     * The Go down.
     */
    private boolean goDown;

    /**
     * Instantiates a new Input.
     */
    public Input() {
        this.goUp = false;
        this.goRight = false;
        this.goLeft = false;
        this.goDown = false;
    }

    /**
     * Is go right boolean.
     *
     * @return the boolean
     */
    public boolean isGoRight() {
        return goRight;
    }

    /**
     * Is go up boolean.
     *
     * @return the boolean
     */
    public boolean isGoUp() {
        return goUp;
    }

    /**
     * Is go left boolean.
     *
     * @return the boolean
     */
    public boolean isGoLeft() {
        return goLeft;
    }

    /**
     * Is go down boolean.
     *
     * @return the boolean
     */
    public boolean isGoDown() {
        return goDown;
    }

    /**
     * Sets go right.
     *
     * @param goRight the go right
     */
    protected void setGoRight(boolean goRight) {
        clear();
        this.goRight = goRight;
    }

    /**
     * Sets go up.
     *
     * @param goUp the go up
     */
    protected void setGoUp(boolean goUp) {
        clear();
        this.goUp = goUp;
    }

    /**
     * Sets go left.
     *
     * @param goLeft the go left
     */
    protected void setGoLeft(boolean goLeft) {
        clear();
        this.goLeft = goLeft;
    }

    /**
     * Sets go down.
     *
     * @param goDown the go down
     */
    protected void setGoDown(boolean goDown) {
        clear();
        this.goDown = goDown;
    }

    private void clear() {
        this.goDown = false;
        this.goUp = false;
        this.goLeft = false;
        this.goRight = false;
    }

    @Override
    public String toString() {
        return "Input{" +
                "goRight=" + goRight +
                ", goUp=" + goUp +
                ", goLeft=" + goLeft +
                ", goDown=" + goDown +
                '}';
    }
}
