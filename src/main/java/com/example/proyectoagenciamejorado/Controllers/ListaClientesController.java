package com.example.proyectoagenciamejorado.Controllers;

import java.util.ArrayList;

import com.example.proyectoagenciamejorado.models.Cita;
import com.example.proyectoagenciamejorado.models.Cliente;
import com.example.proyectoagenciamejorado.models.GestorCitas;
import com.example.proyectoagenciamejorado.models.detalleCita;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaClientesController {

    @FXML
    private TableView<detalleCita> tableView;

    @FXML
    private TableColumn<detalleCita, String> colCliente;

    @FXML
    private TableColumn<detalleCita, String> colFecha;

    @FXML
    private TableColumn<detalleCita, String> colHora;

    private GestorCitas gestorCitas;

    // Este método establece el gestorCitas y carga los datos en la tabla
    public void setGestorCitas(GestorCitas gestorCitas) {
        this.gestorCitas = gestorCitas;
        Cliente cliente  = gestorCitas.encontrarClientePorIdentificacion("123");
        System.out.println(cliente.getNombreCompleto());
        
    }

    @FXML
    private void initialize() {
        // Configurar columnas para que utilicen los métodos de la clase DetalleCita
        colCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
    }

    @FXML
    private void cargarDatos() {
        // Convertir las citas a DetalleCita y añadirlas a la tabla
        ArrayList<Cita> citas = gestorCitas.obtenerCitas();
        ObservableList<detalleCita> datosTabla = FXCollections.observableArrayList();

        for (Cita cita : citas) {
            String nombre = cita.getCliente().getNombreCompleto();
            String fecha = cita.getFecha().toString(); // Convertir LocalDate a String
            String hora = cita.getHora();
            System.out.println(nombre + " " + fecha + " " + hora);

            detalleCita detalleCita = new detalleCita(nombre, fecha, hora);
            datosTabla.add(detalleCita);
        }

        tableView.setItems(datosTabla);
    }
    

    @FXML
    private void Cerrar() {

    }

}
