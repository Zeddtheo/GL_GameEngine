package PhysicEngine;

public abstract class MovableElement {
    private Position coordinate;
    protected HitBox hitBox;

    public MovableElement(Position coordinate) {
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
