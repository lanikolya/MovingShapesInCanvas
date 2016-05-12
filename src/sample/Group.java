package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Group extends Shape {
    List<Shape> listOfGroup = new ArrayList<Shape>();
    public Color colorForGroup;


    public Group(GraphicsContext gc) {
        super(gc);
        colorForGroup = generateColorForGroup();
    }

    public boolean isExist(Shape selected) {
        if (listOfGroup.contains(selected)) {
            return true;
        }
        return false;
    }

    public Color generateColorForGroup() {
        // Java 'Color' class takes 3 floats, from 0 to 1.
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColorForGroup = new Color(r, g, b, 1);
        return randomColorForGroup;
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
        if (k == listOfGroup.size()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean crossDownFrontierOfCanvas() {
        int k = 0;
        for (int i = 0; i < listOfGroup.size(); i++) {
            if (!listOfGroup.get(i).crossDownFrontierOfCanvas()) {
                k++;
            }
        }
        if (k == listOfGroup.size()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean crossRightFrontierOfCanvas() {
        int k = 0;
        for (int i = 0; i < listOfGroup.size(); i++) {
            if (!listOfGroup.get(i).crossRightFrontierOfCanvas()) {
                k++;
            }
        }
        if (k == listOfGroup.size()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean crossLeftFrontierOfCanvas() {
        int k = 0;
        for (int i = 0; i < listOfGroup.size(); i++) {
            if (!listOfGroup.get(i).crossLeftFrontierOfCanvas()) {
                k++;
            }
        }
        if (k == listOfGroup.size()) {
            return false;
        } else {
            return true;
        }
    }

    public void moveUp() {
        for (Shape s : listOfGroup) {
            if (!crossUpFrontierOfCanvas()) {
                s.moveUp();
            } else return;
        }
    }

    public void moveDown() {
        for (Shape s : listOfGroup) {
            if (!crossDownFrontierOfCanvas()) {
                s.moveDown();
            } else return;
        }
    }

    public void moveRight() {
        for (Shape s : listOfGroup) {
            if (!crossRightFrontierOfCanvas()) {
                s.moveRight();
            } else return;
        }
    }

    public void moveLeft() {
        for (Shape s : listOfGroup) {
            if (!crossLeftFrontierOfCanvas()) {
                s.moveLeft();
            } else return;
        }
    }

    public boolean isEmpty() {
        if (listOfGroup.isEmpty()) {
            return true;
        }
        return false;
    }

    public int size(){
        return listOfGroup.size();
    }

    public void addToGroup(Shape shape) {
        listOfGroup.add(shape);
        System.out.println("listOfGroup.size=" + "\t" + listOfGroup.size());
    }

}
