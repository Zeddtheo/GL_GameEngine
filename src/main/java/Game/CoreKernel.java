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

public class CoreKernel {
    public boolean playing = true;

    public MyCharacter player;
    public InputTreatment inputTreatment;

    public Frame frame;
    public CoreKernel() {
        init();
    }

    public List<Entity> entities; // liste des entités dans la zone de jeu
    public List<MovableEntity> movableEntities; //  liste des entités qui bougent
    public List<Entity> testWalls; // liste des murs ou des obstacles

    public void init() {
        // il suffit d'ajouter des objets dans les listes ci dessus pour ses affichages et aussi ses mouvements
        frame = new Frame(this);
        movableEntities = new ArrayList<>();
        entities = new ArrayList<>();
        testWalls = new ArrayList<>();

        inputTreatment = new InputTreatment(new Keyboard(this));

        player = new MyCharacter(new HitBox(new Position(30, 30), 50, 50));
        movableEntities.add(player);
        entities.add(player);
        Wall wall = new Wall(300, 200, 50, 50);
        Wall wall1 = new Wall(100, 100, 25, 100);
        entities.add(wall);
        entities.add(wall1);
        testWalls.add(wall);
        testWalls.add(wall1);
        frame.init();
    };
    /**
     * La boucle a une fréquence qui est de 60hz
     * @throws InterruptedException pour gerer le sleep
     */
    public void execute() throws InterruptedException {

        while (true){
            long start = System.currentTimeMillis();

            extracted();

            frame.refresh();

            long end = System.currentTimeMillis();
            if (end-start < 16){
                Thread.sleep(16 - (end-start));
            }

        }
    }

    public void extracted() {
        //récupération des inputs
        player.setVitesse(inputTreatment.getInput());

        //analyse du jeu pour voir si les mouvement on eu des consequences
        //application des mouvements sur les objets
        for (MovableEntity movables : movableEntities) {
            PhysicEngine.move(movables, testWalls);
        }
    }
}
