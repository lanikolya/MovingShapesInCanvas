package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Star extends Shape {

    private double wide = 50;
    private double high = 50;

    public Star(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        gc.setStroke(Color.RED);
        gc.strokePolygon(new double[]{x, x + wide / 2, x + wide, x, x + wide},
                new double[]{y + high, y, y + high, y + high / 3, y + high / 3}, 5);
    }

    @Override
    public void changeColor(Color color) {
        gc.setStroke(color);
        gc.strokePolygon(new double[]{x, x + wide / 2, x + wide, x, x + wide},
                new double[]{y + high, y, y + high, y + high / 3, y + high / 3}, 5);
    }

    public double getWide(){
        return wide;
    }

    public double getHigh(){
        return high;
    }
}
