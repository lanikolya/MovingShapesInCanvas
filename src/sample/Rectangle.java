package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private double wide = 100;
    private double high = 60;

    public Rectangle(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        checkFrontiersOfCanvas();
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, wide, high);
    }

    public void checkFrontiersOfCanvas() {
        if (crossUpFrontierOfCanvas()) {
            y = 5;
        }
        if (crossDownFrontierOfCanvas()) {
            y = gc.getCanvas().getHeight() - high - 5;
        }
        if (crossRightFrontierOfCanvas()) {
            x = gc.getCanvas().getWidth() - wide - 5;
        }
        if (crossLeftFrontierOfCanvas()) {
            x = 5;
        }
    }

    @Override
    public boolean crossUpFrontierOfCanvas() {
        if (y <= 5) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean crossDownFrontierOfCanvas() {
        if (y >= gc.getCanvas().getHeight() - high - 5) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean crossRightFrontierOfCanvas() {
        if (x >= gc.getCanvas().getWidth() - wide - 5) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean crossLeftFrontierOfCanvas() {
        if (x <= 5) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void changeColor(Color color) {
        checkFrontiersOfCanvas();
        gc.setStroke(color);
        gc.strokeRect(x, y, wide, high);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= x + wide) && (clickX >= x) && (clickY <= y + high) && (clickY >= y)) {
            return true;
        }
        return false;
    }
}
