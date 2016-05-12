package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * Add abstract class for our shapes in order to describe their features in first approximation
 */

/**
 * Create conditions for displaying of figure on canvas
 */
public abstract class Shape {
    Random random = new Random();
    protected GraphicsContext gc;
    protected double x;
    protected double y;
    protected double step = 5;

    /**
     * Define a coordinates of the appearance of figure by random method
     */
    public Shape(GraphicsContext gc) {
        this.gc = gc;
        x = random.nextDouble() * gc.getCanvas().getWidth();
        y = random.nextDouble() * gc.getCanvas().getHeight();

    }


    public GraphicsContext getGc() {
        return gc;
    }


    /**
     * Methods of movement are common. Therefore, define its in this class
     */
    public void moveLeft() {
        x -= step;
    }

    public void moveRight() {
        x += step;
    }

    public void moveUp() {
        y -= step;
    }

    public void moveDown() {
        y += step;
    }

    /**
     * Next methods are original for each figure. Consequently, there we define their names only.
     * More detail description will be directly in classes of each figures.
     */
    public abstract void draw();

    public abstract void changeColor(Color color);

    public abstract boolean isTouched(double clickX, double clickY);

    public abstract boolean crossUpFrontierOfCanvas();
    public abstract boolean crossDownFrontierOfCanvas();
    public abstract boolean crossRightFrontierOfCanvas();
    public abstract boolean crossLeftFrontierOfCanvas();
}
