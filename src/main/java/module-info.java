module aydin.colorchooser {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens aydin.colorchooser to javafx.fxml;
    exports aydin.colorchooser;
}