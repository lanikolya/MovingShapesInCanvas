package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;


public abstract class Shape {
    Random random = new Random();
    protected GraphicsContext gc;
    protected double x;
    protected double y;
    protected double step = 5;

    public Shape(GraphicsContext gc) {
        this.gc = gc;
        x = random.nextDouble()*gc.getCanvas().getWidth();
        y = random.nextDouble()*gc.getCanvas().getHeight();
            }

    public GraphicsContext getGc() {
        return gc;
    }

    public abstract void draw();

    public abstract void changeColor(Color color);

    public void moveLeft() {
        x -= step;
    }

    public void moveRight() {
        x += step;
    }

    public void moveUp() {
        y -= step;
    }

    public void moveDown() {
        y += step;
    }

    public void clean() {
gc.clearRect(0,0,gc.getCanvas().getWidth(),gc.getCanvas().getHeight());
    }
}
