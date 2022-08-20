module com.flipflop.flipflop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    requires javafx.base;
    requires javafx.graphics;
    requires org.kordamp.ikonli.core;
    // add icon pack modules
    requires org.kordamp.ikonli.material2;

    opens com.flipflop.flipflop to javafx.fxml;
    exports com.flipflop.flipflop;
}