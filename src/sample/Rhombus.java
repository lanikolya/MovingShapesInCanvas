package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rhombus extends Shape {

    private double wide = 50;
    private double high = 30;

    public Rhombus(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
    gc.setStroke(Color.PURPLE);
        gc.strokePolygon(new double[]{x,x+wide/2,x+wide,x+wide/2,},
                new double[]{y+high/2,y,y+high/2,y+high},4);
    }

    @Override
    public void changeColor(Color color) {
gc.setStroke(color);
        gc.strokePolygon(new double[]{x,x+wide/2,x+wide,x+wide/2,},
                new double[]{y+high/2,y,y+high/2,y+high},4);
    }

    public double getWide(){
        return wide;
    }

    public double getHigh(){
        return high;
    }
}
