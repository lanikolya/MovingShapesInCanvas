package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {

    private final static int CANVAS_X = 500;
    private final static int CANVAS_Y = 500;
    private Scene scene;
    private GraphicsContext gc;
    ArrayList<Shape> list = new ArrayList<Shape>();
    private int circle = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Geometric figures");
        Canvas canvas = new Canvas(CANVAS_X, CANVAS_Y);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setScene(scene);
        primaryStage.show();
        list.add(new Rectangle(gc));
        setOnKeyPressed();
    }

    public void setOnKeyPressed() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //Add rectangle
                if (event.getCode() == KeyCode.DIGIT1) {
                    list.add(new Rectangle(gc));
                    list.get(list.size() - 1).clean();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    circle++;
                }
                //Add triangle
                if (event.getCode() == KeyCode.DIGIT2) {
                    list.add(new Triangle(gc));
                    list.get(list.size() - 1).clean();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    circle++;
                }
                //Add oval
                if (event.getCode() == KeyCode.DIGIT3) {
                    list.add(new Oval(gc));
                    list.get(list.size() - 1).clean();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    circle++;
                }
                //Add rhombus
                if (event.getCode() == KeyCode.DIGIT4) {
                    list.add(new Rhombus(gc));
                    list.get(list.size() - 1).clean();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    circle++;
                }
                //Add Star
                if (event.getCode() == KeyCode.DIGIT5) {
                    list.add(new Star(gc));
                    list.get(list.size() - 1).clean();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    circle++;
                }
                //Move shapes
                switch (event.getCode()) {
                    case UP:
                        list.get(circle).moveUp();
                        break;
                    case DOWN:
                        list.get(circle).moveDown();
                        break;
                    case RIGHT:
                        list.get(circle).moveRight();
                        break;
                    case LEFT:
                        list.get(circle).moveLeft();
                        break;
                }
                list.get(list.size() - 1).clean();
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).draw();
                }
            }
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}