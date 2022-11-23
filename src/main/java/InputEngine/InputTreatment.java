package InputEngine;

import PhysicEngine.Vector;

/**
 * The type Input treatment.
 */
public class InputTreatment {

    /**
     * The Input.
     */
    Input input;

    /**
     * Instantiates a new Input treatment.
     *
     * @param input the input
     */
    public InputTreatment(Input input) {
        this.input = input;
    }

    /**
     * Get input input.
     *
     * @return the input
     */
    public Input getInput(){
        return input;
    }

}
