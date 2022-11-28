package GraphicEngine;

import javax.swing.*;

public abstract class Frame extends JFrame {


    protected JPanel screen;

    public abstract void init();
    public abstract void refresh();

    public void addElement(Element element) {
        screen.add(element);
    }

    void removeElement(Element element) {
        screen.remove(element);
    }


}
