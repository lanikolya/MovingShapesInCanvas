package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {
    public Triangle(GraphicsContext gc){
        super(gc);
    }

    private int wide = 40;
    private int high = 40;

    @Override
    public void draw() {
        if (x>=gc.getCanvas().getWidth()-wide){
            x=gc.getCanvas().getWidth()-wide-5;
        }
        if (x<=0){
            x=5;
        }
        if (y>=gc.getCanvas().getHeight()-high){
            y=gc.getCanvas().getHeight()-high-5;
        }
        if (y<=0){
            y=5;
        }
        gc.setStroke(Color.ORANGE);
        gc.strokePolygon(new double[]{x,x+wide,x+wide/2},
                new double[]{y+high,y+high,y}, 3);
    }

    @Override
    public void changeColor(Color color) {
        gc.setStroke(color);
        gc.strokePolygon(new double[]{x,x+wide,x+wide/2},
                new double[]{y+high,y+high,y},3);
    }

}
