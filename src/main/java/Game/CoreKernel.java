package Game;

import InputEngine.InputTreatment;
import InputEngine.Keyboard;
import NewGraphicEngine.Frame;
import PhysicEngine.Entity;
import PhysicEngine.PhysicEngine;
import PhysicEngine.Position;

import java.awt.*;
import java.util.*;
import java.util.List;

public class CoreKernel {
    public static int GRID_HEIGHT = 20;
    public static int GRID_WIDTH = 20;
    public static int CELL_HEIGHT = 20;
    public static int CELL_WIDTH = 20;

    public boolean playing = true;

    public Snake snake;

    public Food food;

    public int score = 0;

    public List<Element> elements = new ArrayList<>();
    public InputTreatment inputTreatment;

    public Frame game;
    public CoreKernel() {
        inputTreatment = new InputTreatment(new Keyboard(this));
        inputTreatment.getInput().goRight = true;
        init();
        game = new GameScreen(this);
    }

    public void init() {
        score = 0;
        playing = true;
        elements.clear();

        LinkedList<Entity> body = new LinkedList<>();
        Cell cell1 = new Cell(CELL_WIDTH * 2, CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
        Cell cell2 = new Cell(CELL_WIDTH, CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);

        body.addFirst(cell2);
        body.addFirst(cell1);
        this.snake = new Snake(CELL_WIDTH * 3, CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, body);
        cell1.setNext(snake.head);
        cell1.setPrevious(cell2);
        cell2.setNext(cell1);
        cell2.setPrevious(snake.tail);

        generateFood();
        elements.add(new Element(this.snake.head));
        elements.add(new Element(this.snake.tail));
        for (Entity cell: snake.body) {
            elements.add(new Element(cell));
        }
        elements.add(new Element(this.snake.head));
        elements.add(new Element(food));
    }

    void generateFood() {
        int x, y;
        boolean found;
        do {
            found = true;
            x = new Random().nextInt(GRID_WIDTH - 1) * CELL_WIDTH;
            y = new Random().nextInt(GRID_HEIGHT - 1) * CELL_HEIGHT;
            Rectangle rect = new Rectangle(x, y, CELL_WIDTH, CELL_HEIGHT);
            if (food != null && food.collision().intersects(rect)) continue;

            for (Element element : elements) {
                if (element.entity.collision().intersects(rect)) {
                    found = false;
                    break;
                }
            }
        } while (!found);

        if (food == null) {
            food = new Food(x, y, CELL_WIDTH, CELL_HEIGHT);
        }
        else {
            food.setPos(new Position(x, y));
        }
    }

    /**
     * La boucle a une fréquence qui est de 60hz
     * @throws InterruptedException pour gerer le sleep
     */
    public void execute() throws InterruptedException {

        while (true){
            long start = System.currentTimeMillis();

            extracted();

            game.refresh();

            long end = System.currentTimeMillis();
            if (end-start < 16){
                Thread.sleep(16 - (end-start));
            }

        }
    }

    public void extracted() {
        if (playing) {
            if (!new Rectangle(0, 0, GRID_WIDTH * CELL_WIDTH, GRID_HEIGHT * CELL_HEIGHT)
                    .contains(snake.head.collision())) {
                playing = false;
                return;
            }
            if (
                    snake.head.getCoordinate().getPosX() % CELL_WIDTH == 0 &&
                            snake.head.getCoordinate().getPosY() % CELL_HEIGHT == 0
            ) {
                snake.head.setVitesse(inputTreatment.getInput());
                if (snake.head.collision().contains(food.collision())) {
                    score++;
                    Cell cell = new Cell(food);
                    Cell first = (Cell) snake.body.getFirst();
                    cell.setPrevious(first);
                    cell.setNext(snake.head);
                    first.setNext(cell);
                    snake.body.addFirst(cell);
                    game.addElement(new Element(cell));
                    generateFood();
                } else {
                    Cell last = (Cell) snake.body.removeLast();
                    Cell first = (Cell) snake.body.getFirst();

                    last.setNext(snake.head);
                    last.setPrevious(first);
                    first.setNext(last);
                    last.setPos(snake.head.getPos());
                    snake.body.addFirst(last);
                    ((Cell) snake.body.getLast()).setPrevious(snake.tail);
                }
            }

            List<Entity> list = new LinkedList<>(snake.body.subList(1, snake.body.size()));

            if (PhysicEngine.move(snake.head, list)) {
                PhysicEngine.move(snake.tail, new ArrayList<>());
            } else {
                playing = false;
            }
        }
        else if (((Keyboard) inputTreatment.getInput()).getRestart()){
            restart();
            playing = true;
        }
    }

    private void restart() {
        init();
        game.init();
        game.repaint();
    }
}
