package sample.PhysicEngine;

import Game.Game;
import Game.Head;
import PhysicEngine.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PhysicEngineTest extends Game {

    @Test
    void collision() {
        Head head = new Head(20,20, 30, 30);
        Head head1 = new Head(40 , 40, 30, 30); //ne bouge pas
        assertTrue(head1.collision().intersects(head.collision()));


        head.setPos(new Position(75,75));
        assertFalse(head1.collision().intersects(head.collision()));
    }
}
