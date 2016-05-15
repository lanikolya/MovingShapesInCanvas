package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Star extends Shape {

    public Star(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        checkFrontiersOfCanvas();
        gc.setStroke(Color.RED);
        gc.strokePolygon(new double[]{x, x + Const.WIDE / 2, x + Const.WIDE, x, x + Const.WIDE},
                new double[]{y + Const.HIGH, y, y + Const.HIGH, y + Const.HIGH / 3, y + Const.HIGH / 3}, 5);
    }

    @Override
    public void changeColor(Color color) {
        checkFrontiersOfCanvas();
        gc.setStroke(color);
        gc.strokePolygon(new double[]{x, x + Const.WIDE / 2, x + Const.WIDE, x, x + Const.WIDE},
                new double[]{y + Const.HIGH, y, y + Const.HIGH, y + Const.HIGH / 3, y + Const.HIGH / 3}, 5);
    }
}
