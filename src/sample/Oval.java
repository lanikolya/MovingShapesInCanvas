package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Oval extends Shape {

    private double wide = 30;
    private double high = 60;

    public Oval(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        gc.setStroke(Color.BLUE);
        gc.strokeOval(x, y, wide, high);
    }

    @Override
    public void changeColor(Color color) {
        gc.setStroke(color);
        gc.strokeOval(x, y, wide, high);
    }

    public double getWide(){
        return wide;
    }

    public double getHigh(){
        return high;
    }
}
