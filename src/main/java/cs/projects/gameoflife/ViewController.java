package cs.projects.gameoflife;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class ViewController {
    @FXML
    private AnchorPane rootCanvas;
    @FXML
    private MenuButton menuButtonID;
    @FXML
    private MenuItem conwayID;
    @FXML
    private MenuItem brianID;
    @FXML
    private MenuItem codiID;

    @FXML
    public void initialize() {
        // bind a ResizableCanvas to an AnchorPane
        Grid canvas = new Grid();
        rootCanvas.getChildren().add(canvas);
        canvas.widthProperty().bind(rootCanvas.widthProperty());
        canvas.heightProperty().bind(rootCanvas.heightProperty());
        setupMenuItems();
    }

    private void setupMenuItems() {
        // Set up the action for each MenuItem
        conwayID.setOnAction(event -> menuButtonID.setText(conwayID.getText()));
        brianID.setOnAction(event -> menuButtonID.setText(brianID.getText()));
        codiID.setOnAction(event -> menuButtonID.setText(codiID.getText()));
    }
}