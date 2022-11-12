package PhysicEngine;


public class NewPlayer extends MovableElement {

    private final int lenght = 50;

    public NewPlayer(Position coordinate) {
        super(coordinate);
        super.vitesse = 3;
        super.hitBox = new HitBox(coordinate, lenght, lenght);
    }


}
