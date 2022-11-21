package src;

import Game.CoreKernel;
import Game.Game;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CoreKernel coreKernel = new Game();
        coreKernel.execute();
    }
}
