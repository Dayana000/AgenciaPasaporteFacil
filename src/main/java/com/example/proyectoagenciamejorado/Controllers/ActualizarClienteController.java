package com.example.proyectoagenciamejorado.Controllers;

import com.example.proyectoagenciamejorado.models.Cliente;
import com.example.proyectoagenciamejorado.models.GestorCitas;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class ActualizarClienteController {

    @FXML
    private TextField identificacionTextField;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField correoElectronicoTextField;

    @FXML
    private Button buscarButton;

    @FXML
    private Button actualizarButton;

    @FXML
    private Button cancelarButton;

    private GestorCitas gestorCitas;


    public void setGestorCitas(GestorCitas gestorCitas) {
        this.gestorCitas = gestorCitas;
    }

    @FXML
    private void handleBuscarCliente() {
        String identificacion = identificacionTextField.getText();

        Cliente cliente = gestorCitas.encontrarClientePorIdentificacion(identificacion);
        if (cliente != null) {
        nombreTextField.setText(cliente.getNombreCompleto());
        correoElectronicoTextField.setText(cliente.getCorreoElectronico());
        }
    }

    @FXML
    private void handleActualizarCliente() {
        
        String identificacion = identificacionTextField.getText();
        String nuevoNombre = nombreTextField.getText();
        String nuevoCorreo = correoElectronicoTextField.getText();

        if (nuevoNombre.isEmpty() || nuevoCorreo.isEmpty()) {
            mostrarAlerta("Error", "Por favor, complete todos los campos.");
            return;
        }

        if(gestorCitas.actualizarCliente(identificacion, nuevoNombre, nuevoCorreo)){
            mostrarAlerta("Éxito", "Cliente actualizado correctamente.");
        }else{
            mostrarAlerta("Error", "Cliente no encontrado.");
        }
    }

    @FXML
    private void handleCancelar() {
        identificacionTextField.clear();
        nombreTextField.clear();
        correoElectronicoTextField.clear();
        // Cerrar la ventana o regresar a la ventana principal
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

