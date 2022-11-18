package PhysicEngine;

public class Vector {

    private long Vx;
    private long Vy;

    public Vector(long vx, long vy) {
        Vx = vx;
        Vy = vy;
    }

    public long getVx() {
        return Vx;
    }

    public long getVy() {
        return Vy;
    }

    public boolean isOposite(Vector vector){
        return getVx() + vector.getVx() == 0 && getVy() + vector.getVy() == 0;
    }

    public boolean isOnAbssice(){
        return Vx != 0;
    }


}
