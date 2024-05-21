package cs.projects.gameoflife;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class ViewController {
    @FXML
    private AnchorPane rootCanvas;
    private ResizableCanvas canvas;

    @FXML
    public void initialize(){
        canvas = new ResizableCanvas();
        rootCanvas.getChildren().add(canvas);

        canvas.widthProperty().bind(rootCanvas.widthProperty());
        canvas.heightProperty().bind(rootCanvas.heightProperty());


    }

}