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
        //on compte combien il y a d'input 4 : on bouge pas 3 : on prend celui du millieu
        int countInput = 0;
        if (goUp) {
            countInput++;
        }
        if (goDown) {
            countInput++;

        }
        if (goRight) {
            countInput++;

        }
        if (goLeft) {
            countInput++;
        }

        if (countInput == 0  || countInput == 4) {       //aucune touche press ou toutes les touches presse
            V = new Vector(0,0);
            return;
        }
        if (countInput == 3){
            if (goUp && goDown && goLeft){ //go left
                V = new Vector(-vitesse, 0);
            }
            if (goUp && goDown && goRight){ //go right
                V = new Vector(vitesse, 0);
            }
            if (goUp && goRight && goLeft){ //go up
                V = new Vector(0, -vitesse);
            }
            if (goDown && goRight && goLeft){ //go down
                V = new Vector(0, vitesse);
            }
        }

        if (countInput == 2){
            if (goUp && goRight){
                V = new Vector(2*vitesse/3 ,-2*vitesse/3  );
            }
            if (goDown && goRight){
                V = new Vector(2*vitesse/3 , 2*vitesse/3 );
            }
            if (goUp && goLeft){
                V =new Vector(-2*vitesse/3 ,-2*vitesse/3 );
            }
            if (goDown && goLeft){
                V = new Vector(-2*vitesse/3 , 2*vitesse/3 );
            }

            return ;
        }

        if (countInput == 1){
            if (goRight) V = new Vector(vitesse, 0);
            if (goLeft) V = new Vector(-vitesse, 0);
            if (goDown) V = new Vector(0, vitesse);
            if (goUp) V = new Vector(0, -vitesse);
        }


    }

    public void applyMovement() {
        //coordinate = coordinate + vitesse;
        setCoordinate(new Position(coordinate.getPosX() + V.getVx(),coordinate.getPosY() + V.getVy()));

    }

    public void setVitesse(Input input) {
        setVitesse(input.isGoUp(), input.isGoDown(), input.isGoRight(), input.isGoLeft());
    }
}
