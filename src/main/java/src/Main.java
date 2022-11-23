package src;

import Game.CoreKernel;
import Game.Game;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws InterruptedException the interrupted exception
     */
    public static void main(String[] args) throws InterruptedException {
        CoreKernel coreKernel = new Game();
        coreKernel.execute();
    }
}
