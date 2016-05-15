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
    private Random random;
    protected GraphicsContext gc;
    protected double x;
    protected double y;

    /**
     * Define a coordinates of the appearance of figure by random method
     */
    public Shape(GraphicsContext gc) {
        this.gc = gc;
        random = new Random();
        x = random.nextDouble() * gc.getCanvas().getWidth();
        y = random.nextDouble() * gc.getCanvas().getHeight();
    }

    public GraphicsContext getGc() {
        return gc;
    }

    /**
     * Methods of movement are common. Therefore, define its in this class. Coordinates "x" and "y" are use
     * in shapes construction. Each of this methods changing the original value of
     * appropriate coordinate on value of STEP
     */
    public void moveLeft() {
        x -= Const.STEP;
    }

    public void moveRight() {
        x += Const.STEP;
    }

    public void moveUp() {
        y -= Const.STEP;
    }

    public void moveDown() {
        y += Const.STEP;
    }

    /**
     * Next methods are original for each figure. Consequently, there we define their names only.
     * More detail description will be directly in classes of each figures.
     *
     * Method draw() drawing shape
     */
    public abstract void draw();

    /**
     * Method changeColor() redrawing shape with new random color
     *
     * @param color the random color for the changeColor()
     */
    public abstract void changeColor(Color color);

    /**
     * Method checkFrontiersOfCanvas() check whether shapes cross the borders of Canvas and if its cross - override
     * appropriate coordinates in such way, how is necessary.
     */
    public void checkFrontiersOfCanvas() {
        if (crossUpFrontierOfCanvas()) {
            y = Const.INDENT;
        }
        if (crossDownFrontierOfCanvas()) {
            y = gc.getCanvas().getHeight() - Const.HIGH - Const.INDENT;
        }
        if (crossRightFrontierOfCanvas()) {
            x = gc.getCanvas().getWidth() - Const.WIDE - Const.INDENT;
        }
        if (crossLeftFrontierOfCanvas()) {
            x = Const.INDENT;
        }
    }

    /**
     * Method isTouched determines was click on shape field or not
     *
     * @param clickX the value of coordinate "x" when you click
     * @param clickY the value of coordinate "y" when you click
     * @return true or false
     */
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= x + Const.WIDE) && (clickX >= x) && (clickY <= y + Const.HIGH) && (clickY >= y)) {
            return true;
        }
        return false;
    }

    /**
     * Next methods determine crossing appropriate borders of Canvas
     *
     * @return true or false
     */
    public boolean crossUpFrontierOfCanvas() {
        return y <= Const.INDENT;
    }

    public boolean crossDownFrontierOfCanvas() {
        return y >= gc.getCanvas().getHeight() - Const.HIGH - Const.INDENT;
    }

    public boolean crossRightFrontierOfCanvas() {
        return x >= gc.getCanvas().getWidth() - Const.WIDE - Const.INDENT;
    }

    public boolean crossLeftFrontierOfCanvas() {
        return x <= Const.INDENT;
    }
}
