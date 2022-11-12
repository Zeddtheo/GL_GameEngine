package NewGraphicEngine;

import javax.swing.*;
import java.awt.*;

public class Element extends JPanel {

    ImageIcon image;
    public Element(ImageIcon image){
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getImage(),
                0,
                0,
                null);
    }
}
