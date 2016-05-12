package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Star extends Shape {

    private double wide = 60;
    private double high = 60;

    public Star(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        checkFrontiersOfCanvas();
        gc.setStroke(Color.RED);
        gc.strokePolygon(new double[]{x, x + wide / 2, x + wide, x, x + wide},
                new double[]{y + high, y, y + high, y + high / 3, y + high / 3}, 5);
    }



    @Override
    public void changeColor(Color color) {
        checkFrontiersOfCanvas();
        gc.setStroke(color);
        gc.strokePolygon(new double[]{x, x + wide / 2, x + wide, x, x + wide},
                new double[]{y + high, y, y + high, y + high / 3, y + high / 3}, 5);
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
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= x + wide) && (clickX >= x) && (clickY <= y + high) && (clickY >= y)) {
            return true;
        }
        return false;
    }


}
