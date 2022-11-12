package InputEngine;

import java.awt.*;

public abstract class Input extends Frame {
    private boolean goRight;
    private boolean goUp;
    private boolean goLeft;
    private boolean goDown;

    public Input() {
        this.goUp = false;
        this.goRight = false;
        this.goLeft = false;
        this.goDown = false;
    }

    public boolean isGoRight() {
        return goRight;
    }

    public boolean isGoUp() {
        return goUp;
    }

    public boolean isGoLeft() {
        return goLeft;
    }

    public boolean isGoDown() {
        return goDown;
    }

    protected void setGoRight(boolean goRight) {
        this.goRight = goRight;
    }

    protected void setGoUp(boolean goUp) {
        this.goUp = goUp;
    }

    protected void setGoLeft(boolean goLeft) {
        this.goLeft = goLeft;
    }

    protected void setGoDown(boolean goDown) {
        this.goDown = goDown;
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
