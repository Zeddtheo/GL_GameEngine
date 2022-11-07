package PhysicEngine.Collider;

import javax.swing.*;

public class BoxCollider extends Collider{
    int x;
    int y;
    int width;
    int m;
    int height;
    public BoxCollider(int x, int y, int m){
        this.x = x;
        this.y = y;
        this.m = m;
    }
    public boolean checkCollision(BoxCollider b2){
        if(x<= (b2.x+b2.m) && y<=(b2.y+b2.m)&&x>=b2.x&&y>b2.y){
            return true;
        }else if(x+m<=b2.x+b2.m&&y+m<=b2.y+b2.m&&x+m>=b2.x&&y+m>=b2.y){
            return true;
        }else if(x+m<=b2.x+b2.m&&y<=b2.y+b2.m&&x+m>=b2.m&&y>=b2.y){
            return true;
        }else if(x<=b2.x+b2.m&&y+m<=b2.y+b2.m&&x>=b2.x&&y+m>=b2.y){
            return true;
        }else{
            return false;
        }
    }
}
