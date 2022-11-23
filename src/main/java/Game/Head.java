package Game;

import PhysicEngine.MovableEntity;
import PhysicEngine.Vector;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * The type Head.
 */
public class Head extends MovableEntity {
    BufferedImage headUp;
    BufferedImage headLeft;
    BufferedImage headDown;
    BufferedImage headRight;

    /**
     * Instantiates a new Head.
     *
     * @param x      the x of left up corner
     * @param y      the y of left up corner
     * @param width  the width
     * @param height the height
     */
    public Head(int x, int y, int width, int height) {
        super(x, y, width, height);
        V = new Vector(1, 0);
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("Head.png")));
            headLeft = image;
            headUp = rotate(image, 90);
            BufferedImage image1 = flip(this.image);
            headRight = rotate(image1, 180);
            headDown = rotate(headRight, 90);
        } catch (IOException ignored) {
        }
    }

    @Override
    public BufferedImage getImage() {
        if (V.getVx() > 0) return headRight;
        else if (V.getVx() < 0) return headLeft;
        else if (V.getVy() > 0) return headDown;
        else return headUp;
    }

}
