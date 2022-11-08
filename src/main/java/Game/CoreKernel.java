package Game;

import PhysicEngine.MovableElement;
import PhysicEngine.NewPlayer;
import PhysicEngine.Position;

public class CoreKernel {
    MovableElement player = new NewPlayer(new Position(30, 30));

    /**
     * La boucle a une fréquence qui est de 60hz
     * @throws InterruptedException pour gerer le sleep
     */
    public void execute() throws InterruptedException {
        while (true){
            long start = System.currentTimeMillis();

            //récupération des inputs
            //application des mouvements sur les objets
            //analyse du jeu pour voir si les mouvement on eu des consequences


            long end = System.currentTimeMillis();
            if (end-start < 16){
                Thread.sleep(16 - (end-start));
            }

        }
    }
}
