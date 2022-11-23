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

}
