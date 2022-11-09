import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class MyRectangle {

    private Rectangle rect;

    public MyRectangle(double xLoc, double yLoc, Color color, Pane myPane) {
        this.rect = new Rectangle(xLoc, yLoc, Constants.RECT_WIDTH, Constants.RECT_HEIGHT);
        this.rect.setFill(color);
        myPane.getChildren().add(this.rect);
    }

    /**
     * This helper method moves your rectangle to the left (in the negative x
     * direction)
     */
    public void moveLeft() {
        this.rect.setX(this.rect.getX() - Constants.OFFSET);
    }

    /**
     * This helper method moves your rectangle to the right (in the positive x
     * direction)
     * You will fill in this method yourself
     */
    public void moveRight() {
        this.rect.setX(this.rect.getX() + Constants.OFFSET);
    }
}