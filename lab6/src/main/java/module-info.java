module lab6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    exports lab6.Main;
    opens lab6.Main to javafx.fxml;
    exports lab6.Controller;
    opens lab6.Controller to javafx.fxml;

    opens lab6.PropertyFactory;
}