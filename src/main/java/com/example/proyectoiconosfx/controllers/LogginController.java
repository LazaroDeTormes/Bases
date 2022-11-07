package com.example.proyectoiconosfx.controllers;

import com.example.proyectoiconosfx.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.events.Event;

import java.io.IOException;

public class LogginController {

    @FXML
    private TextField usuarioTexto;

    @FXML
    private TextField contraTexto;




    @FXML
    public void accionAceptar() throws IOException {
        String usuario=usuarioTexto.getText();
        String pass=contraTexto.getText();

        DaoPerfiles con=new DaoPerfiles();

        if(con.comprobarUsuario(usuario,pass)){
         

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pantallaPrincipal.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage=new Stage();
            stage.setTitle("Iconos Fx");
            stage.setScene(scene);
            stage.setMinWidth(740);
            stage.setMinHeight(490);
            stage.show();



        }

    }
}
