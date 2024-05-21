package cs.projects.gameoflife;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ResizableCanvas extends Canvas {

    private static final int cellSize = 15;
    private boolean[][] cells;

    public ResizableCanvas() {
        initializeCells();

        widthProperty().addListener(evt -> {
            initializeCells();
            draw();
        });
        heightProperty().addListener(evt -> {
            initializeCells();
            draw();
        });

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, this::handleMouseClick);
    }

    private void initializeCells() {
        int numCols = (int) (getWidth() / cellSize);
        int numRows = (int) (getHeight() / cellSize);
        cells = new boolean[numRows][numCols];
    }

    private void handleMouseClick(MouseEvent event) {
        double mouseX = event.getX();
        double mouseY = event.getY();
        int col = (int) (mouseX / cellSize);
        int row = (int) (mouseY / cellSize);

        if (row < cells.length && col < cells[0].length) {
            cells[row][col] = !cells[row][col];
        }
        draw();
    }

    private void draw() {
        double width = getWidth();
        double height = getHeight();
        int numRows = (int) (height / cellSize);
        int numCols = (int) (width / cellSize);

        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, width, height);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(0.5);

        for (int i = 0; i <= numCols; i++) {
            gc.strokeLine(i * cellSize, 0, i * cellSize, height);
        }
        for (int i = 0; i <= numRows; i++) {
            gc.strokeLine(0, i * cellSize, width, i * cellSize);
        }

        gc.setFill(Color.BLACK);
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (cells[row][col]) {
                    gc.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                }
            }
        }
    }

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double prefWidth(double height) {
        return getWidth();
    }

    @Override
    public double prefHeight(double width) {
        return getHeight();
    }
}