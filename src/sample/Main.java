package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.ArrayList;



public class Main extends Application {

    private final static double CANVAS_X = 1000;
    private final static double CANVAS_Y = 600;
    private Scene scene;
    private GraphicsContext gc;
    //Create list which will contained adds shapes
    ArrayList<Shape> list = new ArrayList<Shape>();
    //Create list which will contained all our shapes (for "random shape" method)
    ArrayList<Shape> set = new ArrayList<Shape>();
    //Create counter for access to concrete shape in list
    private int counter = -1;
    private Group group;
    //    final Text actiontarget = new Text();

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane group = new BorderPane();
        primaryStage.setTitle("Geometric figures");
        Canvas canvas = new Canvas(CANVAS_X, CANVAS_Y);
        GridPane grid = createGrid();
        addButtonClean(grid);
        addButtonHelp(grid);
        grid.add(group, 1, 1);
        scene = new Scene(grid);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setScene(scene);
        group.setCenter(canvas);
        primaryStage.show();
        setOnKeyPressed();
        additionInGroup();
        setOnMousePressed();
        setOnKeyPressed();
    }

    /**
     * Add button "Clean"
     */
    private void addButtonClean(GridPane grid) {
        Button buttonClean = new Button("Clean");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(buttonClean);
        grid.add(hbBtn, 1, 4);
        buttonClean.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                actionClean();
            }
        });
    }

    /**
     * Add button "Help"
     */
    private void addButtonHelp(GridPane grid) {
        Button buttonHelp = new Button("Help");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(buttonHelp);
        grid.add(hbBtn, 1, 3);
        buttonHelp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                new HTMLTableHelp();
            }
        });
    }

    /**
     * Create GridPane for building buttons
     */

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setPadding(new Insets(0, 0, 0, 0));
        return grid;
    }

    /**
     * Method setOnMousePressed for detection of click of mouse and selection of shapes to addition in group
     */

    public void setOnMousePressed() {
        scene.setOnMousePressed(
                event -> {

                    double clickX = event.getSceneX();
                    double clickY = event.getSceneY();

                    System.out.println("clickX" + clickX);
                    System.out.println("clickY" + clickY);
                    System.out.println("isControlDown=" + event.isControlDown());

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isTouched(clickX, clickY) && event.isControlDown()) {
                            Shape selected = list.get(i);
                            if (group.isExist(selected)) {
                                return;
                            } else {
                                group.addToGroup(selected);
                            }
                            counter = list.size() - 1;
                            list.remove(selected);
                            drawAllShapesInList();
                            group.draw();
                        }
                    }

                    System.out.println("mouseClick" + counter);
                });
    }

    /**
     * Method additionInGroup created for add group of shapes to common list as one shape
     */
    public void additionInGroup() {
        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.CONTROL) {
                list.add(group);
            }
        });
    }

    /**
     * Create method to perform certain actions after pushing certain buttons from keyboard
     */
    public void setOnKeyPressed() {
        scene.setOnKeyPressed(event -> {

            //Add rectangle
            if (event.getCode() == KeyCode.DIGIT1) {
                list.add(new Rectangle(gc));
                drawAllShapesInList();
                counter++;
                System.out.println("add Rectangle" + counter);

            }
            //Add triangle
            if (event.getCode() == KeyCode.DIGIT2) {
                list.add(new Triangle(gc));
                drawAllShapesInList();
                counter++;
                System.out.println("add Triangle" + counter);
            }
            //Add oval
            if (event.getCode() == KeyCode.DIGIT3) {
                list.add(new Oval(gc));
                drawAllShapesInList();
                counter++;
                System.out.println("add Oval" + counter);
            }
            //Add rhombus
            if (event.getCode() == KeyCode.DIGIT4) {
                list.add(new Rhombus(gc));
                drawAllShapesInList();
                counter++;
                System.out.println("add Rhombus" + counter);
            }
            //Add Star
            if (event.getCode() == KeyCode.DIGIT5) {
                list.add(new Star(gc));
                drawAllShapesInList();
                counter++;
                System.out.println("add Star" + counter);
            }
            //Add random shape
            if (event.getCode() == KeyCode.R) {
                set.add(new Rectangle(gc));
                set.add(new Triangle(gc));
                set.add(new Oval(gc));
                set.add(new Rhombus(gc));
                set.add(new Star(gc));
                int index = (int) (Math.random() * set.size());
                list.add(set.get(index));
                drawAllShapesInList();
                counter++;
                System.out.println("add Random" + counter);
            }
            //Create group
            if (event.isControlDown()) {
                group = new Group(gc);
            }
            //Clean Canvas
            if (event.getCode() == KeyCode.C) {
                cleanCanvas();
            }
            //Help (reference)
            if (event.getCode() == KeyCode.H) {
                new HTMLTableHelp();
            }

            switch (event.getCode()) {
                case UP:
                    if (!list.isEmpty()) {
                        list.get(counter).moveUp();
                    }
                    break;
                case DOWN:
                    if (!list.isEmpty()) {
                        list.get(counter).moveDown();
                    }
                    break;
                case RIGHT:
                    if (!list.isEmpty()) {
                        list.get(counter).moveRight();
                    }
                    break;
                case LEFT:
                    if (!list.isEmpty()) {
                        list.get(counter).moveLeft();
                    }
                    break;
            }

/**
 * Switching between a shapes
 */

            /**
             * Next shape
             */
            if (event.getCode() == KeyCode.P) {
                if (counter < (list.size() - 1)) {
                    counter++;
                    System.out.println("increase counter key P" + counter);
                }
            }
            /**
             * Previous shape
             */
            if (event.getCode() == KeyCode.M) {
                if (counter > 0) {
                    counter--;
                    System.out.println("decrease key M" + counter);
                }
            }

            drawAllShapesInList();
        });
    }

    /**
     * Cleaning of Canvas and drawing of all shapes in list
     */
    private void drawAllShapesInList() {
        cleanCanvas();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).draw();
        }
    }

    /**
     * Cleaning of Canvas
     */
    public void cleanCanvas() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    /**
     * Clean Canvas and list
     */
    public void actionClean() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        list.clear();
        counter = -1;
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}