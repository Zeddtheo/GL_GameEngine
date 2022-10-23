package sample.PhysicEngine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PositionTest {

    @Test
    void getPosX() {
        Position testPos = new Position(2,3);
        assertEquals(2,testPos.getPosX());
        assertNotEquals(3,testPos.getPosX());
    }

    @Test
    void setPosX() {
        Position testPos = new Position(2,3);
        testPos.setPosX(3);
        assertEquals(3,testPos.getPosX());
        assertNotEquals(2,testPos.getPosX());
    }

    @Test
    void getPosY() {
        Position testPos = new Position(2,3);
        assertEquals(3,testPos.getPosY());
        assertNotEquals(2,testPos.getPosY());
    }

    @Test
    void setPosY() {
        Position testPos = new Position(2,3);
        testPos.setPosY(2);
        assertEquals(2,testPos.getPosY());
        assertNotEquals(3,testPos.getPosY());
    }
}