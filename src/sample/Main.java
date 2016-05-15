package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;


public class Main extends Application {


    private Scene scene;
    private GraphicsContext gc;
    //Create listShapes which will contained adds shapes
    private ArrayList<Shape> listShapes = new ArrayList<Shape>();
    //Create counter for access to concrete shape in listShapes
    private int counter = -1;
    private Group group;


    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane group = new BorderPane();
        primaryStage.setTitle(Const.PAGE_TITLE);
        Canvas canvas = new Canvas(Const.CANVAS_X, Const.CANVAS_Y);
        GridPane grid = createGrid();
        addButtonClean(grid);
        addButtonHelp(grid);
        grid.add(group, Const.COLUMN_INDEX, Const.ROW_INDEX_FOR_GRID);
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
        HBox hbBtn = new HBox(Const.SPACING_FOR_BUTTON);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(buttonClean);
        grid.add(hbBtn, Const.COLUMN_INDEX, Const.ROW_INDEX_FOR_CLEAN);
        buttonClean.setOnMouseClicked(event -> actionClean());
    }

    /**
     * Add button "Help"
     */
    private void addButtonHelp(GridPane grid) {
        Button buttonHelp = new Button("Help");
        HBox hbBtn = new HBox(Const.SPACING_FOR_BUTTON);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(buttonHelp);
        grid.add(hbBtn, Const.COLUMN_INDEX, Const.ROW_INDEX_FOR_HELP);
        buttonHelp.setOnMouseClicked(event -> new HTMLTableHelp());
    }

    /**
     * Create GridPane for building buttons
     */

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(Const.HORIZONTAL_GAP);
        grid.setVgap(Const.VERTICAL_GAP);
        grid.setPadding(new Insets(Const.PADDING_TOP, Const.PADDING_RIGHT, Const.PADDING_BOTTOM, Const.PADDING_LEFT));
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

                    for (int i = 0; i < listShapes.size(); i++) {
                        if (listShapes.get(i).isTouched(clickX, clickY) && event.isControlDown()) {
                            Shape selected = listShapes.get(i);
                            if (group.isExist(selected)) {
                                return;
                            } else {
                                group.addToGroup(selected);
                            }
                            counter = listShapes.size() - 1;
                            listShapes.remove(selected);
                            drawAllShapesInList();
                            group.draw();
                        }
                    }

                    System.out.println("mouseClick" + counter);
                });
    }

    /**
     * Method additionInGroup created for add group of shapes to common listShapes as one shape
     */
    public void additionInGroup() {
        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.CONTROL) {
                listShapes.add(group);
            }
        });
    }

    /**
     * Create method to perform certain actions after pushing certain buttons from keyboard
     */
    public void setOnKeyPressed() {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case DIGIT1:
                    //Add rectangle
                    listShapes.add(new Rectangle(gc));
                    drawAllShapesInList();
                    counter++;
                    System.out.println("add Rectangle" + counter);
                    break;
                case DIGIT2:
                    //Add triangle
                    listShapes.add(new Triangle(gc));
                    drawAllShapesInList();
                    counter++;
                    System.out.println("add Triangle" + counter);
                    break;
                case DIGIT3:
                    //Add oval
                    listShapes.add(new Oval(gc));
                    drawAllShapesInList();
                    counter++;
                    System.out.println("add Oval" + counter);
                    break;
                case DIGIT4:
                    //Add rhombus
                    listShapes.add(new Rhombus(gc));
                    drawAllShapesInList();
                    counter++;
                    System.out.println("add Rhombus" + counter);
                    break;
                case DIGIT5:
                    //Add Star
                    listShapes.add(new Star(gc));
                    drawAllShapesInList();
                    counter++;
                    System.out.println("add Star" + counter);
                    break;
                case R:
                    //Add random shape
                    addRandomShapeToList();
                    drawAllShapesInList();
                    counter++;
                    System.out.println("add Random" + counter);
                    break;
                case UP:
                    if (!listShapes.isEmpty()) {
                        listShapes.get(counter).moveUp();
                    }
                    break;
                case DOWN:
                    if (!listShapes.isEmpty()) {
                        listShapes.get(counter).moveDown();
                    }
                    break;
                case RIGHT:
                    if (!listShapes.isEmpty()) {
                        listShapes.get(counter).moveRight();
                    }
                    break;
                case LEFT:
                    if (!listShapes.isEmpty()) {
                        listShapes.get(counter).moveLeft();
                    }
                    break;
                case P:
                    //Switch to next shape
                    if (counter < (listShapes.size() - 1)) {
                        counter++;
                        System.out.println("increase counter key P" + counter);
                    }
                    break;
                case M:
                    //Switch to previous Shape
                    if (counter > 0) {
                        counter--;
                        System.out.println("decrease key M" + counter);
                    }
                    break;
            }
            //Create group
            if (event.isControlDown()) {
                group = new Group(gc);
            }
            drawAllShapesInList();
        });
    }

    /**
     * Cleaning of Canvas and drawing of all shapes in listShapes
     */
    private void drawAllShapesInList() {
        cleanCanvas();
        for (int i = 0; i < listShapes.size(); i++) {
            listShapes.get(i).draw();
        }
    }

    /**
     * Cleaning of Canvas
     */
    public void cleanCanvas() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    /**
     * Clean Canvas and listShapes
     */
    public void actionClean() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        listShapes.clear();
        counter = -1;
    }

    /**
     * Create method which add random shape in "listShapes"
     */
    private void addRandomShapeToList() {
        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;
        switch (randomNumber) {
            case 1:
                listShapes.add(new Rectangle(gc));
                break;
            case 2:
                listShapes.add(new Triangle(gc));
                break;
            case 3:
                listShapes.add(new Oval(gc));
                break;
            case 4:
                listShapes.add(new Rhombus(gc));
                break;
            case 5:
                listShapes.add(new Star(gc));
                break;
        }
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}