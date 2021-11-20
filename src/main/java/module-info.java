module app.spacecat.imagetoasciifinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens app.spacecat.imagetoasciifinal to javafx.fxml;
    exports app.spacecat.imagetoasciifinal;
}