package sample.PhysicEngine;

public class Orientation {



    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;


    public Orientation(boolean up, boolean down, boolean left, boolean right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public String getDirection(){
        if(up) {return "up";}
        else if(down) {return "down";}
        else if(left) {return "left";}
        else {return "right";}
    }

    public void clearDirection(){
        up = false;
        down = false;
        left = false;
        right = false;
    }

    public void faceUp(){
        clearDirection();
        up = true;
    }
    public void faceDown(){
        clearDirection();
        down = true;
    }

    public void faceLeft(){
        clearDirection();
        left = true;
    }

    public void faceRight(){
        clearDirection();
        right = true;
    }



}
