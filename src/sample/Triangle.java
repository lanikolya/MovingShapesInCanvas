package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {
    public Triangle(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        checkFrontiersOfCanvas();
        gc.setStroke(Color.ORANGE);
        gc.strokePolygon(new double[]{x, x + Const.WIDE, x + Const.WIDE / 2},
                new double[]{y + Const.HIGH, y + Const.HIGH, y}, Const.QUANTITY_POINTS_FOR_TRIANGLE);
    }

    @Override
    public void changeColor(Color color) {
        checkFrontiersOfCanvas();
        gc.setStroke(color);
        gc.strokePolygon(new double[]{x, x + Const.WIDE, x + Const.WIDE / 2},
                new double[]{y + Const.HIGH, y + Const.HIGH, y}, Const.QUANTITY_POINTS_FOR_TRIANGLE);
    }
}

