package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Group extends Shape {
    private ArrayList<Shape> listOfGroup = new ArrayList<>();
    public Color colorForGroup;


    public Group(GraphicsContext gc) {
        super(gc);
        colorForGroup = generateColorForGroup();
    }

    /**
     * Create method which check presence of selected object in "listOfGroup"
     */
    public boolean isExist(Shape selected) {
        return listOfGroup.contains(selected);
    }

    /**
     * Create method to generate random color
     */
    public Color generateColorForGroup() {
        // Java 'Color' class takes 3 floats, from 0 to 1.
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b, 1);
    }

    @Override
    public void draw() {
        if (!listOfGroup.isEmpty()) {
            for (Shape s : listOfGroup) {
                s.changeColor(colorForGroup);
            }
        }
    }

    @Override
    public void changeColor(Color color) {
        draw();
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        for (Shape s :
                listOfGroup) {
            if (s.isTouched(clickX, clickY)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean crossUpFrontierOfCanvas() {
        int k = 0;
        for (int i = 0; i < listOfGroup.size(); i++) {
            if (!listOfGroup.get(i).crossUpFrontierOfCanvas()) {
                k++;
            }
        }
        return !(k == listOfGroup.size());
    }

    @Override
    public boolean crossDownFrontierOfCanvas() {
        int k = 0;
        for (int i = 0; i < listOfGroup.size(); i++) {
            if (!listOfGroup.get(i).crossDownFrontierOfCanvas()) {
                k++;
            }
        }
        return !(k == listOfGroup.size());
    }

    @Override
    public boolean crossRightFrontierOfCanvas() {
        int k = 0;
        for (int i = 0; i < listOfGroup.size(); i++) {
            if (!listOfGroup.get(i).crossRightFrontierOfCanvas()) {
                k++;
            }
        }
        return !(k == listOfGroup.size());
    }

    @Override
    public boolean crossLeftFrontierOfCanvas() {
        int k = 0;
        for (int i = 0; i < listOfGroup.size(); i++) {
            if (!listOfGroup.get(i).crossLeftFrontierOfCanvas()) {
                k++;
            }
        }
        return !(k == listOfGroup.size());
    }

    @Override
    public void moveUp() {
        for (Shape s : listOfGroup) {
            if (!crossUpFrontierOfCanvas()) {
                s.moveUp();
            } else {
                return;
            }
        }
    }

    @Override
    public void moveDown() {
        for (Shape s : listOfGroup) {
            if (!crossDownFrontierOfCanvas()) {
                s.moveDown();
            } else {
                return;
            }
        }
    }

    @Override
    public void moveRight() {
        for (Shape s : listOfGroup) {
            if (!crossRightFrontierOfCanvas()) {
                s.moveRight();
            } else {
                return;
            }
        }
    }

    @Override
    public void moveLeft() {
        for (Shape s : listOfGroup) {
            if (!crossLeftFrontierOfCanvas()) {
                s.moveLeft();
            } else {
                return;
            }
        }
    }

    /**
     * Create method to add shapes in "listOfGroup"
     */
    public void addToGroup(Shape shape) {
        listOfGroup.add(shape);
        System.out.println("listOfGroup.size=" + "\t" + listOfGroup.size());
    }

    @Override
    public GraphicsContext getGc() {
        return super.getGc();
    }
}
