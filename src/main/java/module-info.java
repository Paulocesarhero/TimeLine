module time.line.timeline {
    requires javafx.controls;
    requires javafx.fxml;


    opens time.line.timeline to javafx.fxml;
    exports time.line.timeline;
}