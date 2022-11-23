package sample.GraphicEngine;

import Game.CoreKernel;
import NewGraphicEngine.Frame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrameTest {

    @Test
    public void FrameNameTest(){
        CoreKernel coreKernel = new CoreKernel();
        Frame frame = new Frame(coreKernel);
        assertTrue(frame.getTitle().contains("Player Move"));

    }

}
