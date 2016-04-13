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
        getGc().setStroke(Color.BLACK);
        getGc().strokeRect(x,y, wide, high);
    }

    @Override
    public void changeColor(Color color) {
        gc.setStroke(color);
        gc.strokeRect(x,y,wide,high);
    }

    public double getWide(){
        return wide;
    }

    public double getHigh(){
        return high;
    }
}
