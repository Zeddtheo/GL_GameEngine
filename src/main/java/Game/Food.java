package Game;

import PhysicEngine.Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * The type Food.
 */
public class Food extends Entity {
    /**
     * Instantiates a new Food.
     *
     * @param x      the x
     * @param y      the y
     * @param width  the width
     * @param height the height
     */
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
