package Game;

import NewGraphicEngine.Element;
import InputEngine.InputTreatment;
import InputEngine.Keyboard;
import NewGraphicEngine.Frame;
import PhysicEngine.Entity;
import PhysicEngine.PhysicEngine;
import PhysicEngine.Position;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * The type Game.
 */
public class Game extends CoreKernel {
    /**
     * The constant GRID_HEIGHT.
     */
    public static int GRID_HEIGHT = 20;
    /**
     * The constant GRID_WIDTH.
     */
    public static int GRID_WIDTH = 20;
    /**
     * The constant CELL_HEIGHT.
     */
    public static int CELL_HEIGHT = 20;
    /**
     * The constant CELL_WIDTH.
     */
    public static int CELL_WIDTH = 20;

    /**
     * The Snake.
     */
    public Snake snake;

    /**
     * The Food.
     */
    public Food food;

    @Override
    public void init() {
        frame = new Frame(this);
        movableEntities = new ArrayList<>();
        entities = new ArrayList<>();
        walls = new ArrayList<>();

        inputTreatment = new InputTreatment(new Keyboard(this));
        inputTreatment.getInput().goRight = true;

        LinkedList<Entity> body = new LinkedList<>();
        body.add(new Cell(GRID_WIDTH * 2, GRID_HEIGHT, CELL_WIDTH, CELL_HEIGHT));
        body.add(new Cell(GRID_WIDTH, GRID_HEIGHT, CELL_WIDTH, CELL_HEIGHT));

        this.snake = new Snake(CELL_WIDTH * 3, CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT, body);
        generateFood();
        entities.add(this.snake.head);
        entities.add(this.snake.tail);
        entities.addAll(snake.body);
        entities.add(this.snake.head);
        entities.add(food);
        frame.init();

    }

    @Override
    public void extracted() {
        if (playing) {
            if (
                    snake.head.getCoordinate().getPosX() % GRID_WIDTH == 0 &&
                            snake.head.getCoordinate().getPosY() % GRID_HEIGHT == 0
            ) {
                snake.head.setVitesse(inputTreatment.getInput());
                if (snake.head.collision().contains(food.collision())) {
                    Cell cell = new Cell(food);
                    entities.add(cell);
                    snake.body.addFirst(cell);
                    Element element = new Element(cell);
                    frame.screen.elements.add(element);
                    frame.screen.add(element);
                    generateFood();
                    frame.refresh();
                } else {
                    Entity last = snake.body.removeLast();
                    last.setPos(snake.head.getPos());
                    snake.body.addFirst(last);
                }
            }

            List<Entity> list = new LinkedList<>(snake.body.subList(1, snake.body.size()));

            if (!new Rectangle(0, 0, GRID_WIDTH * CELL_WIDTH, GRID_HEIGHT * CELL_HEIGHT)
                    .contains(snake.head.getNextStep()))
                playing = false;
            else if (PhysicEngine.move(snake.head, list)) {
                PhysicEngine.move(snake.tail);
            } else {
                playing = false;
            }
        }
    }

    /**
     * Generate food.
     */
    void generateFood() {
        int x, y;
        boolean found;
        do {
            found = true;
            x = new Random().nextInt(GRID_WIDTH - 1) * CELL_WIDTH;
            y = new Random().nextInt(GRID_HEIGHT - 1) * CELL_HEIGHT;
            Rectangle rect = new Rectangle(x, y, CELL_WIDTH, CELL_HEIGHT);
            if (food != null && food.collision().intersects(rect)) continue;

            for (Entity entity : entities) {
                if (entity.collision().intersects(rect)) {
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
}
