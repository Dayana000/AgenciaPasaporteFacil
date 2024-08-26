module com.example.proyectoagenciamejorado {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens com.example.proyectoagenciamejorado to javafx.fxml;
    exports com.example.proyectoagenciamejorado;
    exports com.example.proyectoagenciamejorado.Controllers;
    opens com.example.proyectoagenciamejorado.Controllers to javafx.fxml;
    exports com.example.proyectoagenciamejorado.models;
    opens com.example.proyectoagenciamejorado.models to javafx.fxml;
}