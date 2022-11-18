package PhysicEngine;

import Game.CoreKernel;
import InputEngine.Input;
import Interface.MovableObject;

import java.awt.*;

public abstract class MovableEntity extends Entity implements MovableObject {
    private Vector V;
    protected long vitesse;

    public MovableEntity(HitBox hitBox) {
        super(hitBox);
        vitesse = 2;
        this.V = new Vector(1,0);
    }

    public void setCoordinate(Position position){
        hitBox.refresh(position);
    }

    public Position getCoordinate() {
        return hitBox.getCorner();
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public void setVitesse(boolean goUp, boolean goDown, boolean goRight, boolean goLeft ){
        //si les directions demandées sont opposées
        if ((goUp && goDown) || (goLeft && goRight)) return;

        int count = 0;
        int x = 0, y = 0;
        if (goUp){
            y-=1;
             count++;
        }
        if (goDown){
            y+=1;
            count++;
        }
        if (goLeft){
            x -= 1;
            count++;
        }

        if (goRight){
            x+=1;
            count++;
        }

        //si pas de modif on garde la meme vitesse
        if (count == 0){
            return;
        }

        int x1 = (int) ((double) vitesse * x );
        int y1 = (int) ((double) vitesse * y );
        Vector newVector = new Vector(x1, y1);

        //si le vecteur est l'opposé de celui deja existant alors on ne fait rien
        if (V.isOposite(newVector)) return;


        if(V.isOnAbssice() && !newVector.isOnAbssice() && super.getPos().getPosX() % CoreKernel.corridor != 0){
            return;
        }

        if(!V.isOnAbssice() && newVector.isOnAbssice() && super.getPos().getPosY() % CoreKernel.corridor != 0){
            return;
        }

        //si il y avait qu'une direction demandé
        if (count == 1){
            V = newVector;
            return;
        }

        //sinon on prend
        if(V.getVx() == newVector.getVx()){
            V = new Vector(V.getVx(), 0);
        }
        if(V.getVy() == newVector.getVy()){
            V = new Vector(0, V.getVy());
        }
    }

    /**
     * On regarde si on peut faire changer de direction le serpent
     * @return oui ou on
     */
    public boolean canChangeForx(){
        return getCoordinate().getPosX() % CoreKernel.corridor == 0;
    }

    public boolean canChangeFory(){
        return getCoordinate().getPosY() % CoreKernel.corridor == 0;
    }


    public void applyMovement() {
        long vx = V.getVx();
        long vy = V.getVy();
        int x = (int) hitBox.getCorner().getPosX();
        int y = (int) hitBox.getCorner().getPosY();
        if (vx == 0 && vy == 0) return;
        setCoordinate(new Position(x + V.getVx(),y + V.getVy()));
    }

    public void setVitesse(Input input) {
        setVitesse(input.isGoUp(), input.isGoDown(), input.isGoRight(), input.isGoLeft());
    }

    @Override
    public void setSpeed(int speed) {
        vitesse = speed;
    }

    @Override
    public long getSpeed() {
        return vitesse;
    }

    public Vector getV(){
        return V;
    }

    @Override
    public Rectangle getNextStep() {
        long vx = V.getVx();
        long vy = V.getVy();
        int x = (int) hitBox.getCorner().getPosX();
        int y = (int) hitBox.getCorner().getPosY();
        if (vx == 0 && vy == 0) return new  Rectangle(x, y, getWidth(), getHeight());

        return new Rectangle((int) (vx + x), (int) (vy + y), getWidth(), getHeight());
    }

    @Override
    public void goNextStep() {
        applyMovement();
    }
}
