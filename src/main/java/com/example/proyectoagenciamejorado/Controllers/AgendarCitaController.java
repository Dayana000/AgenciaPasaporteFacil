package com.example.proyectoagenciamejorado.Controllers;

import com.example.proyectoagenciamejorado.models.Cita;
import com.example.proyectoagenciamejorado.models.Cliente;
import com.example.proyectoagenciamejorado.models.GestorCitas;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AgendarCitaController {

    @FXML
    private TextField nombreCompletoTextField;

    @FXML
    private TextField identificacionTextField;

    @FXML
    private TextField correoElectronicoTextField;

    @FXML
    private DatePicker fechaCitaDatePicker;

    @FXML
    private TextField horaCitaTextField;

    @FXML
    private Button agendarButton;

    @FXML
    private Button cancelarButton;

    
    private GestorCitas gestorCitas; 
    
    
    public void setGestorCitas(GestorCitas gestorCitas) {
        this.gestorCitas = gestorCitas;
    }

    @FXML
    private void handleAgendarCita() {
        String nombreCompleto = nombreCompletoTextField.getText();
        String identificacion = identificacionTextField.getText();
        String correoElectronico = correoElectronicoTextField.getText();
        LocalDate fechaCita = fechaCitaDatePicker.getValue();
        String horaCita = horaCitaTextField.getText();

        if (nombreCompleto.isEmpty() || identificacion.isEmpty() || correoElectronico.isEmpty() || fechaCita == null || horaCita.isEmpty()) {
            mostrarAlerta("Error", "Por favor, complete todos los campos.");
            return;
        }

        Cliente cliente = new Cliente(nombreCompleto, identificacion, correoElectronico);
        Cita nuevaCita = new Cita(cliente, fechaCita, horaCita);

        Cliente clienteC = gestorCitas.encontrarClientePorIdentificacion(identificacion);
        if (clienteC == null) {
            System.out.println("agregado");
            gestorCitas.agregarCliente(cliente);
        }
        gestorCitas.agregarCita(nuevaCita);

        mostrarAlerta("Éxito", "Cita agendada correctamente.");
        handleCancelar();
    }

    @FXML
    private void handleCancelar() {
        nombreCompletoTextField.clear();
        identificacionTextField.clear();
        correoElectronicoTextField.clear();
        fechaCitaDatePicker.setValue(null);
        horaCitaTextField.clear();

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
