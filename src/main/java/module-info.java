    module com.example.proyectoiconosfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;


    opens com.example.proyectoiconosfx to javafx.fxml;
    exports com.example.proyectoiconosfx;
}