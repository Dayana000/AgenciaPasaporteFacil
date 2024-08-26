package com.example.proyectoagenciamejorado.Controllers;
import com.example.proyectoagenciamejorado.models.GestorCitas;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EliminarClienteController {

    @FXML
    private TextField id; // Campo para ingresar la identificación del cliente

    @FXML
    private Button eliminarClienteButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private DatePicker fechaCita;

    private GestorCitas gestorCitas; 
    
    
    public void setGestorCitas(GestorCitas gestorCitas) {
        this.gestorCitas = gestorCitas;
    }

    
    @FXML
    private void eliminarCliente() {
        String identificacion = id.getText();

        if (identificacion.isEmpty()) {
            mostrarAlerta("Error", "Por favor, ingrese la identificación del cliente.");
            return;
        }

        if(gestorCitas.eliminarCitaPorFechaYCliente(fechaCita.getValue(), identificacion)){
            mostrarAlerta("Exito", "Cita eliminada");
        }
    }
    
    @FXML
    private void cancelar() {
        Stage stage = (Stage) cancelarButton.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
