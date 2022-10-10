    module com.example.proyectoiconosfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;


    opens com.example.proyectoiconosfx to javafx.fxml;
    exports com.example.proyectoiconosfx;
        exports com.example.proyectoiconosfx.models;
        opens com.example.proyectoiconosfx.models to javafx.fxml;
        exports com.example.proyectoiconosfx.controllers;
        opens com.example.proyectoiconosfx.controllers to javafx.fxml;
    }