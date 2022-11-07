package sample.newPhysicEngine;

import sample.PhysicEngine.Position;

public class Player extends MoovableElement{

    private final int length = 10;

    public Player(Position coordinate) {
        super(coordinate);
        super.hitBox = new HitBox(coordinate, length);
    }


}
