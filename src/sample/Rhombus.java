package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rhombus extends Shape {

    public Rhombus(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        checkFrontiersOfCanvas();
        gc.setStroke(Color.PURPLE);
        gc.strokePolygon(new double[]{x, x + Const.WIDE / 2, x + Const.WIDE, x + Const.WIDE / 2,},
                new double[]{y + Const.HIGH / 2, y, y + Const.HIGH / 2, y + Const.HIGH}, Const.QUANTITY_POINTS_FOR_RHOMBUS);
    }

    @Override
    public void changeColor(Color color) {
        checkFrontiersOfCanvas();
        gc.setStroke(color);
        gc.strokePolygon(new double[]{x, x + Const.WIDE / 2, x + Const.WIDE, x + Const.WIDE / 2,},
                new double[]{y + Const.HIGH / 2, y, y + Const.HIGH / 2, y + Const.HIGH}, Const.QUANTITY_POINTS_FOR_RHOMBUS);
    }
}
