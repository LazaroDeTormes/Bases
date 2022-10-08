package com.example.proyectoiconosfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pantallaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Iconos Fx");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
        Controller control=new Controller();
        /*control.aleatorio();*/
        control.buscarGrupo();
    }
}