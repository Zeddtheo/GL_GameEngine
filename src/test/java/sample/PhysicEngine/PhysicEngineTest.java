package sample.PhysicEngine;

import Game.GameScreen;
import Game.Head;
import PhysicEngine.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PhysicEngineTest extends GameScreen {

    @Test
    void collision() {
        //collisions
        Head head = new Head(20,20, 30, 30);
        Head head1 = new Head(40 , 40, 30, 30); //ne bouge pas
        assertTrue(head1.collision().intersects(head.collision()));

        head.setPos(new Position(50,50));
        assertTrue(head1.collision().intersects(head.collision()));

        head.setPos(new Position(20,50));
        assertTrue(head1.collision().intersects(head.collision()));

        head.setPos(new Position(50,20));
        assertTrue(head1.collision().intersects(head.collision()));

        // pas collisions
        head.setPos(new Position(75,75));
        assertFalse(head1.collision().intersects(head.collision()));

    }


    @Test
    void movement(){
        Head head = new Head(20,20, 30, 30);
        head.setSpeed(2);

        head.setVitesse(true, false, false, false);
        head.applyMovement();

        assertEquals(head.getCoordinate().getPosX(), 20);
        assertEquals(head.getCoordinate().getPosY(), 18);

        head.setVitesse(false, true, false, false);
        head.applyMovement();

        assertEquals(head.getCoordinate().getPosX(), 20);
        assertEquals(head.getCoordinate().getPosY(), 20);

        head.setVitesse(false, false, true, false);
        head.applyMovement();

        assertEquals(head.getCoordinate().getPosX(), 22);
        assertEquals(head.getCoordinate().getPosY(), 20);

        head.setVitesse(false, false, false, true);
        head.applyMovement();

        assertEquals(head.getCoordinate().getPosX(), 20);
        assertEquals(head.getCoordinate().getPosY(), 20);
    }

}
