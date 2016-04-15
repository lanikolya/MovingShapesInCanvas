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


public class Main extends Application {

    private final static double CANVAS_X = 500;
    private final static double CANVAS_Y = 500;
    private Scene scene;
    private GraphicsContext gc;
    //Create list wich will contained adds shapes
    ArrayList<Shape> list = new ArrayList<Shape>();
    ArrayList<Shape> set = new ArrayList<Shape>();
    private int circle = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane group = new BorderPane();
        primaryStage.setTitle("Geometric figures");
        Canvas canvas = new Canvas(CANVAS_X, CANVAS_Y);
        scene = new Scene(group);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setScene(scene);
        group.setCenter(canvas);
        primaryStage.show();
        setOnKeyPressed();
    }

    public void setOnKeyPressed() {
        scene.setOnKeyPressed(event -> {
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
            //Add random shape
            if (event.getCode() == KeyCode.SPACE) {
                set.add(new Rectangle(gc));
                set.add(new Triangle(gc));
                set.add(new Oval(gc));
                set.add(new Rhombus(gc));
                set.add(new Star(gc));
                int index = (int) (Math.random() * set.size());
                list.add(set.get(index));
                list.get(list.size() - 1).clean();
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).draw();
                }
                circle++;
            }
            //Move shapes
            switch (event.getCode()) {
                case UP:
                    list.get(circle - 1).moveUp();
                    break;
                case DOWN:
                    list.get(circle - 1).moveDown();
                    break;
                case RIGHT:
                    list.get(circle - 1).moveRight();
                    break;
                case LEFT:
                    list.get(circle - 1).moveLeft();
                    break;
            }

            list.get(list.size() - 1).clean();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).draw();
            }
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}