package InputEngine;

import PhysicEngine.Vector;

public class InputTreatment {

    Input input;

    long vitesse = 2;

    public InputTreatment(Input input) {
        this.input = input;
    }

    public Input getInput(){
        return input;
    }

    public Vector getVector() {

        //on compte combien il y a d'input 4 : on bouge pas 3 : on prend celui du millieu
        int countInput = 0;
        if (input.isGoUp()) {
            countInput++;
        }
        if (input.isGoDown()) {
            countInput++;

        }
        if (input.isGoRight()) {
            countInput++;

        }
        if (input.isGoLeft()) {
            countInput++;
        }

        if (countInput == 0  || countInput == 4) {       //aucune touche press ou toutes les touches presse
            return new Vector(0, 0);
        }

        if (countInput == 3){
            if (input.isGoUp()&& input.isGoDown()&& input.isGoLeft()){ //go left

            }
            if (input.isGoUp()&& input.isGoDown()&& input.isGoRight()){ //go right

            }
            if (input.isGoUp( )&& input.isGoRight() && input.isGoLeft()){ //go up

            }
            if (input.isGoDown()&& input.isGoRight()&& input.isGoLeft()){ //go down

            }
        }

        if (countInput == 2){
            if (input.isGoUp()&& input.isGoRight()){
                return new Vector(vitesse / 2,-vitesse / 2);
            }
            if (input.isGoDown()&& input.isGoRight()){
                return new Vector(vitesse / 2,vitesse / 2);
            }
            if (input.isGoUp()&& input.isGoLeft()){
                return new Vector(-vitesse / 2,-vitesse / 2);
            }
            if (input.isGoDown()&& input.isGoLeft()){
                return new Vector(-vitesse / 2,vitesse / 2);
            }

            return new Vector(0, 0);
        }

        if (countInput == 1){
            if (input.isGoRight()) return new Vector(vitesse, 0);
            if (input.isGoLeft()) return new Vector(-vitesse, 0);
            if (input.isGoDown()) return new Vector(0, vitesse);
            if (input.isGoUp()) return new Vector(0, -vitesse);
        }
        return new Vector(0, 0);
    }
}
