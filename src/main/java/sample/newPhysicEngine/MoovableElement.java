package sample.newPhysicEngine;

import sample.PhysicEngine.Position;


public abstract class MoovableElement {
    private Position coordinate;
    protected HitBox hitBox;

    public MoovableElement(Position coordinate) {
        this.coordinate = coordinate;
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
}
