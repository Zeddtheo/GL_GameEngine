package PhysicEngine;


public class NewPlayer extends MovableElement {

    private final int lenght = 10;

    public NewPlayer(Position coordinate) {
        super(coordinate);
        super.hitBox = new HitBox(coordinate, lenght, lenght);
    }


}
