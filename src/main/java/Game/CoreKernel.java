package Game;

import InputEngine.InputTreatment;
import InputEngine.Keyboard;
import GraphicEngine.Frame;
import PhysicEngine.Entity;
import PhysicEngine.PhysicEngine;
import PhysicEngine.MovableEntity;
import PhysicEngine.HitBox;
import PhysicEngine.Position;

import java.util.ArrayList;
import java.util.List;

public class CoreKernel {
    public MyCharacter player;
    public InputTreatment inputTreatment;
    public Frame frame;

    public static int corridor = 32;
    public CoreKernel() {
        init();
    }

    public List<Entity> entities = new ArrayList<>(); // liste des entités dans la zone de jeu
    public List<MovableEntity> movableEntities = new ArrayList<>(); //  liste des entités qui bougent
    public List<Entity> testWalls = new ArrayList<>(); // liste des murs ou des obstacles

    void init() {
        // il suffit d'ajouter des objets dans les listes ci dessus pour ses affichages et aussi ses mouvements
        player = new MyCharacter(new HitBox(new Position(32, 32), 32, 32));
        movableEntities.add(player);

        inputTreatment = new InputTreatment(new Keyboard());
        entities = new ArrayList<>();
        testWalls = new ArrayList<>();
        entities.add(player);
        /*Wall wall = new Wall(new HitBox(new Position(300, 200), 50, 50));
        Wall wall1 = new Wall(new HitBox(new Position(100, 100), 25, 100));
        entities.add(wall);
        entities.add(wall1);
        testWalls.add(wall);
        testWalls.add(wall1);*/
        frame = new Frame(this);
    };
    /**
     * La boucle a une fréquence qui est de 60hz
     * @throws InterruptedException pour gerer le sleep
     */
    public void execute() throws InterruptedException {

        while (true){
            long start = System.currentTimeMillis();


            //récupération des inputs
            player.setVitesse(inputTreatment.getInput());

            //analyse du jeu pour voir si les mouvements ont eux des consequences
            //application des mouvements sur les objets
            for (MovableEntity movables : movableEntities) {
                if (!PhysicEngine.move(movables, testWalls)){ //si le mouvement n'a pas pu etre fait
                    //TODO : arrêt du jeu
                }
            }

            frame.refresh();

            long end = System.currentTimeMillis();
            if (end-start < 16){
                Thread.sleep(16 - (end-start));
            }

        }
    }
}
