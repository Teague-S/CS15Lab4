import javax.swing.Action;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class PaneOrganizer {
    MyRectangle movingRect;
    BorderPane root = new BorderPane();

    public PaneOrganizer() {
        this.root = new BorderPane();
        this.root.setStyle("-fx-background-color: #e4cbff");
        this.createRectsPane();
        this.createButtonPane();
        this.createLabelPane();
    }

    public BorderPane getRoot() {
        return root;
    }

    private void createRectsPane() {
        Pane rectsPane = new Pane();
        rectsPane.setPrefSize(Constants.RECTS_PANE_WIDTH, Constants.RECTS_PANE_HEIGHT);
        rectsPane.setStyle(Constants.RECTS_PANE_COLOR);
        this.root.setCenter(rectsPane);
        new MyRectangle(Constants.STATIONARY_RECT_XLOC, Constants.STATIONARY_RECT_YLOC,
                Constants.STATIONARY_RECT_COLOR, rectsPane);
        this.movingRect = new MyRectangle(Constants.MOVING_RECT_XLOC, Constants.MOVING_RECT_YLOC,
                Constants.MOVING_RECT_COLOR, rectsPane);
        rectsPane.setOnKeyPressed(KeyEvent -> handleKeyPress(KeyEvent));
        rectsPane.setFocusTraversable(true);
    }

    private void createButtonPane() {
        Pane buttonPane = new Pane(); // This instantiates the button pane
        buttonPane.setPrefSize(Constants.BUTTON_PANE_WIDTH, Constants.BUTTON_PANE_HEIGHT); // This sets its size
        buttonPane.setStyle(Constants.BUTTON_PANE_COLOR); // This sets its color
        this.root.setLeft(buttonPane); // This adds the buttonPane to the BorderPane
        Button button = new Button("Quit"); // This instantiates the button
        buttonPane.getChildren().add(button); // Adds the button to the pane
        button.setOnAction((ActionEvent e) -> System.exit(0)); // Makes button click quit the program
        buttonPane.setFocusTraversable(false);
        button.setFocusTraversable(false); // Stops 'quit' button from being highlighted on launch
    }

    private void createLabelPane() {
        HBox labelpane = new HBox();
        labelpane.setPrefSize(Constants.LABEL_PANE_WIDTH, Constants.LABEL_PANE_HEIGHT); // This sets its size
        labelpane.setStyle(Constants.LABEL_PANE_COLOR); // This sets its color
        Label label = new Label("Hi, I'm a label!");
        labelpane.getChildren().add(label);
        this.root.setBottom(labelpane);
        labelpane.setAlignment(Pos.CENTER);
    }

    private void handleKeyPress(KeyEvent e) {
        KeyCode keyPressed = e.getCode();
        if (keyPressed == KeyCode.SPACE) {
            System.out.println("Spacebar!");
        }
        if (keyPressed == KeyCode.LEFT) {
            movingRect.moveLeft();
        } else if (keyPressed == KeyCode.RIGHT) {
            movingRect.moveRight();
        }
        // this makes sure that once the user input is handled, the event is consumed
        e.consume();
    }
}