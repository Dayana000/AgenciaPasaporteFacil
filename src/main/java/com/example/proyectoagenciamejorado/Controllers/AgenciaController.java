package com.example.proyectoagenciamejorado.Controllers;

import com.example.proyectoagenciamejorado.AgenciaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AgenciaController {

    AgenciaApplication application = new AgenciaApplication();

    @FXML
    private Button actualizarClienteButton;

    @FXML
    private Button agendarCitaButton;

    @FXML
    private Button eliminarClienteButton;

    @FXML
    private Button listarClienteButton;

    @FXML
    private Button salirButton;

    @FXML
    void actualizarAccionBoton(ActionEvent event) {

        application.mostrarVentanaActualizar();
    }

    @FXML
    void agendarAccionBoton(ActionEvent event) {

        application.mostrarVentanaAgendar();
    }

    @FXML
    void eliminarAccionBoton(ActionEvent event) {

        application.mostrarVentanaEliminar();
    }

    @FXML
    void listaClienteAccionBoton(ActionEvent event) {

        application.mostrarVentanaLista();
    }


    public void setApplication(AgenciaApplication application){

        this.application = application;
    }
}