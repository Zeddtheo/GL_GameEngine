package GraphicEngine;

import javax.swing.*;

/**
 * The type Frame.
 */
public abstract class Frame extends JFrame {


    /**
     * The Screen.
     */
    protected JPanel screen;

    /**
     * Init.
     */
    public abstract void init();

    /**
     * Refresh.
     */
    public abstract void refresh();

    /**
     * Add element.
     *
     * @param element the element
     */
    public void addElement(Element element) {
        screen.add(element);
    }

    /**
     * Remove element.
     *
     * @param element the element
     */
    void removeElement(Element element) {
        screen.remove(element);
    }

    /**
     * Gets screen.
     *
     * @return the screen
     */
    public JPanel getScreen() {
        return screen;
    }
}
