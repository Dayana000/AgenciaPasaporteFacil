package com.example.proyectoagenciamejorado;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.proyectoagenciamejorado.Controllers.ActualizarClienteController;
import com.example.proyectoagenciamejorado.Controllers.AgendarCitaController;
import com.example.proyectoagenciamejorado.Controllers.EliminarClienteController;
import com.example.proyectoagenciamejorado.Controllers.ListaClientesController;
import com.example.proyectoagenciamejorado.models.GestorCitas;

public class AgenciaApplication extends Application {

    private GestorCitas gestorCitas = new GestorCitas();

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(AgenciaApplication.class.getResource("Agencia-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void mostrarVentanaAgendar() {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("agendar-cita.fxml"));
        Parent root = fxmlLoader.load();

        // Obtener el controlador y pasarle la instancia de GestorCitas
        AgendarCitaController controller = fxmlLoader.getController();
        controller.setGestorCitas(gestorCitas);

        Stage stage = new Stage();
        stage.setTitle("Agendar Cita");
        stage.setScene(new Scene(root));
        stage.show();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void mostrarVentanaActualizar() {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("actualizar-cliente.fxml"));
        Parent root = fxmlLoader.load();

        // Obtener el controlador y pasarle la instancia de GestorCitas
        ActualizarClienteController controller = fxmlLoader.getController();
        controller.setGestorCitas(gestorCitas);

        Stage stage = new Stage();
        stage.setTitle("Actualizar Cliente");
        stage.setScene(new Scene(root));
        stage.show();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void mostrarVentanaEliminar() {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("eliminar-cliente.fxml"));
        Parent root = fxmlLoader.load();

        // Obtener el controlador y pasarle la instancia de GestorCitas
        EliminarClienteController controller = fxmlLoader.getController();
        controller.setGestorCitas(gestorCitas);

        Stage stage = new Stage();
        stage.setTitle("Eliminar Cliente");
        stage.setScene(new Scene(root));
        stage.show();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void mostrarVentanaLista() {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("lista-clientes.fxml"));
        Parent root = fxmlLoader.load();

        // Obtener el controlador y pasarle la instancia de GestorCitas
        ListaClientesController controller = fxmlLoader.getController();
        controller.setGestorCitas(gestorCitas);

        Stage stage = new Stage();
        stage.setTitle("Lista de Clientes");
        stage.setScene(new Scene(root));
        stage.show();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        launch();
    }
}