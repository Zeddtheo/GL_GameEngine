package Game;

import PhysicEngine.Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Food extends Entity {
    protected Food(int x, int y, int width, int height) {
        super(x, y, width, height);
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("Apple.png")));
        } catch (IOException ignored) {
        }
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }
}
