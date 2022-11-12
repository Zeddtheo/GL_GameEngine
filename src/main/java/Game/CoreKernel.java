package Game;

import InputEngine.Input;
import InputEngine.InputTreatment;
import InputEngine.Keyboard;
import NewGraphicEngine.Frame;
import PhysicEngine.MovableElement;
import PhysicEngine.NewPlayer;
import PhysicEngine.PhysicEngine;
import PhysicEngine.Position;

public class CoreKernel {
    public MovableElement player = new NewPlayer(new Position(30, 30));
    public InputTreatment inputTreatment = new InputTreatment(new Keyboard());

    Frame frame = new Frame(this);
    /**
     * La boucle a une fréquence qui est de 60hz
     * @throws InterruptedException pour gerer le sleep
     */
    public void execute() throws InterruptedException {

        while (true){
            long start = System.currentTimeMillis();


            //récupération des inputs
            player.setVitesse(inputTreatment.getInput());

            //analyse du jeu pour voir si les mouvement on eu des consequences
            //application des mouvements sur les objets
            PhysicEngine.move(player);


            frame.refresh();

            long end = System.currentTimeMillis();
            if (end-start < 16){
                Thread.sleep(16 - (end-start));
            }

        }
    }
}
