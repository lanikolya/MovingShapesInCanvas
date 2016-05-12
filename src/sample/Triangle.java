package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {
    public Triangle(GraphicsContext gc) {
        super(gc);
    }

    private int wide = 60;
    private int high = 60;

    @Override
    public void draw() {
        checkFrontiersOfCanvas();
        gc.setStroke(Color.ORANGE);
        gc.strokePolygon(new double[]{x, x + wide, x + wide / 2},
                new double[]{y + high, y + high, y}, 3);
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
        gc.strokePolygon(new double[]{x, x + wide, x + wide / 2},
                new double[]{y + high, y + high, y}, 3);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= x + wide) && (clickX >= x) && (clickY <= y + high) && (clickY >= y)) {
            return true;
        }
        return false;
    }
}

