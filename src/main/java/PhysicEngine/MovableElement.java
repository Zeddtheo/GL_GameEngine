package PhysicEngine;

import InputEngine.Input;

public abstract class MovableElement {
    private Position coordinate;

    private Vector V;

    protected long vitesse;
    protected HitBox hitBox;

    public MovableElement(Position coordinate) {
        this.coordinate = coordinate;
        this.V = new Vector(0,0);
    }

    public void setCoordinate(Position position){
        this.coordinate = position;
        hitBox.refresh(position);
    }

    public Position getCoordinate() {
        return coordinate;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public void setVitesse(boolean goUp, boolean goDown, boolean goRight, boolean goLeft ){
        if ((goUp && goDown) || (goLeft && goRight)) return;

        int x = 0, y = 0;
        if (goUp){
            y-=1;
        }
        if (goDown){
            y+=1;
        }
        if (goLeft){
            x-=1;
        }
        if (goRight){
            x+=1;
        }

        double l = Math.sqrt((double) x * x + y * y);
        int x1 = (int) ((double) vitesse * x / l);
        int y1 = (int) ((double) vitesse * y / l);
        V = new Vector(x1, y1);

    }

    public void applyMovement() {
        //coordinate = coordinate + vitesse;
        setCoordinate(new Position(coordinate.getPosX() + V.getVx(),coordinate.getPosY() + V.getVy()));

    }

    public void setVitesse(Input input) {
        setVitesse(input.isGoUp(), input.isGoDown(), input.isGoRight(), input.isGoLeft());
    }
}
