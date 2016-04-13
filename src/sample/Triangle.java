package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {
    public Triangle(GraphicsContext gc){
        super(gc);
    }

    private int size = 40;

    @Override
    public void draw() {
        gc.setStroke(Color.ORANGE);
        gc.strokePolygon(new double[]{x,x+size,x+size/2},
                new double[]{y,y-size,y-size/2}, 3);
    }

    @Override
    public void changeColor(Color color) {
        gc.setStroke(color);
        gc.strokePolygon(new double[]{x,x+size,x+size/2},
                new double[]{y,y,y-size},3);
    }

    public int getSize(){
        return size;
    }
}
