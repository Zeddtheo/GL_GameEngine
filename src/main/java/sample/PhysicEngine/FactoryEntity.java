package sample.PhysicEngine;

public abstract class FactoryEntity {
    private Position pos;

    public FactoryEntity(Position pos) {
        this.pos = pos;
    }

    public boolean isMainCharacter(){
        return false;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }
}
