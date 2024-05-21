module cs.projects.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;


    opens cs.projects.gameoflife to javafx.fxml;
    exports cs.projects.gameoflife;
}