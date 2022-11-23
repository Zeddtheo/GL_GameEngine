package Game;

import InputEngine.InputTreatment;
import InputEngine.Keyboard;
import NewGraphicEngine.Frame;
import PhysicEngine.Entity;
import PhysicEngine.PhysicEngine;
import PhysicEngine.MovableEntity;
import PhysicEngine.HitBox;
import PhysicEngine.Position;

import java.util.*;

/**
 * The type Core kernel.
 */
public class CoreKernel {
    /**
     * The Playing.
     */
    public boolean playing = true;

    /**
     * The Player.
     */
    public MyCharacter player;
    /**
     * The Input treatment.
     */
    public InputTreatment inputTreatment;

    /**
     * The Frame for graphic engine.
     */
    public Frame frame;

    /**
     * Instantiates a new Core kernel.
     */
    public CoreKernel() {
        init();
    }

    /**
     * The Entities.
     */
    public List<Entity> entities;
    /**
     * The Movable entities.
     */
    public List<MovableEntity> movableEntities;
    /**
     * The walls.
     */
    public List<Entity> walls;

    /**
     * Init the game.
     */
    public void init() {
        frame = new Frame(this);
        movableEntities = new ArrayList<>();
        entities = new ArrayList<>();
        walls = new ArrayList<>();

        inputTreatment = new InputTreatment(new Keyboard(this));

        player = new MyCharacter(new HitBox(new Position(30, 30), 50, 50));
        movableEntities.add(player);
        entities.add(player);
        Wall wall = new Wall(300, 200, 50, 50);
        Wall wall1 = new Wall(100, 100, 25, 100);
        entities.add(wall);
        entities.add(wall1);
        walls.add(wall);
        walls.add(wall1);
        frame.init();
    }

    /**
     * The frequencies of this loop is 60hz
     *
     * @throws InterruptedException for the sleep
     */
    @SuppressWarnings({"InfiniteLoopStatement", "BusyWait"})

    public void execute() throws InterruptedException {

        for (;;){
            long start = System.currentTimeMillis();

            extracted();

            frame.refresh();

            long end = System.currentTimeMillis();
            if (end-start < 16){
                Thread.sleep(16 - (end-start));
            }
        }
    }

    /**
     * Extracted.
     */
    public void extracted() {
        //get player input
        player.setVitesse(inputTreatment.getInput());

        for (MovableEntity movables : movableEntities) {
            PhysicEngine.move(movables, walls);
        }
    }
}
