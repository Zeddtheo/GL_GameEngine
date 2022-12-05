package Game;


import GraphicEngine.Element;
import GraphicEngine.Frame;

import javax.swing.*;
import java.util.List;

/**
 * The type Game screen.
 */
public class GameScreen extends Frame {
    /**
     * The Core kernel.
     */
    CoreKernel coreKernel;
    /**
     * The Elements.
     */
    List<Element> elements;
    /**
     * The Score.
     */
    JTextArea score;

    /**
     * Instantiates a new Game screen.
     *
     * @param coreKernel the core kernel
     */
    public GameScreen(CoreKernel coreKernel) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Serpent");
        setSize(400,430);
        setResizable(false);
        setVisible(true);
        this.coreKernel = coreKernel;
        elements = coreKernel.elements;
        screen = new JPanel();
        screen.setLayout(null);
        screen.addKeyListener((Keyboard) coreKernel.inputTreatment.getInput());
        screen.setFocusable(true);
        screen.setVisible(true);
        add(screen);
        score = new JTextArea();
        screen.setBounds(0, 0, 400, 400);

        init();
    }

    @Override
    public void addElement(Element element) {
        super.addElement(element);
        element.setBounds(element.entity.collision());
        element.setVisible(true);
        elements.add(element);
    }

    @Override
    public void init() {
        screen.removeAll();
        for (Element element : elements) {
            element.setBounds(element.entity.collision());
            element.setVisible(true);
            screen.add(element);
        }

        score.setText("score : " + coreKernel.score);
        score.setBounds(0, 0, 100, 15);

        screen.add(score);
    }

    @Override
    public void refresh() {
        for (Element element : elements) {
            element.setBounds(element.entity.collision());
        }
        score.setText("score : " + coreKernel.score);
        screen.getGraphics().drawLine(0, 404, 400, 404);
    }
}
