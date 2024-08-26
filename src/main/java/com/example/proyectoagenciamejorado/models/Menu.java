package com.example.proyectoagenciamejorado.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private GestorCitas gestorCitas;
    private Scanner scanner;

    public Menu(GestorCitas gestorCitas) {
        this.gestorCitas = gestorCitas;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Gestión ---");
            System.out.println("1. Agregar Cita");
            System.out.println("2. Actualizar Cliente");
            System.out.println("3. Eliminar Cita por Fecha y Cliente");
            System.out.println("4. Mostrar Todas las Citas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
    
            switch (opcion) {
                case 1:
                    agregarCitaMenu();
                    break;
                case 2:
                    actualizarClienteMenu();
                    break;
                case 3:
                    eliminarCitaPorFechaYClienteMenu();
                    break;
                case 4:
                    mostrarTodasLasCitas();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private void agregarCitaMenu() {
        System.out.print("Ingrese la identificación del cliente: ");
        String identificacion = scanner.nextLine();
        
        Cliente cliente = gestorCitas.encontrarClientePorIdentificacion(identificacion);
        if (cliente == null) {
            System.out.println("Cliente no encontrado. Ingrese los datos para crear un nuevo cliente.");
            System.out.print("Ingrese el nombre completo del cliente: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el correo electrónico del cliente: ");
            String correo = scanner.nextLine();
    
            cliente = new Cliente(nombre, identificacion, correo);
            gestorCitas.agregarCliente(cliente);
            System.out.println("Cliente creado exitosamente.");
        }
    
        System.out.print("Ingrese la fecha de la cita (formato: YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);
    
        System.out.print("Ingrese la hora de la cita (formato: HH:mm): ");
        String hora = scanner.nextLine();
    
        Cita nuevaCita = new Cita(cliente, fecha, hora);
        gestorCitas.agregarCita(nuevaCita);
        System.out.println("Cita agregada exitosamente.");
    }
    

    private void actualizarClienteMenu() {
        System.out.print("Ingrese la identificación del cliente a actualizar: ");
        String identificacion = scanner.nextLine();

        Cliente cliente = gestorCitas.encontrarClientePorIdentificacion(identificacion);
        if (cliente != null) {
            System.out.print("Ingrese el nuevo nombre completo del cliente: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo correo electrónico del cliente: ");
            String nuevoCorreo = scanner.nextLine();

            if (gestorCitas.actualizarCliente(identificacion, nuevoNombre, nuevoCorreo)) {
                System.out.println("Cliente actualizado exitosamente.");
            } else {
                System.out.println("Error al actualizar el cliente.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private void eliminarCitaPorFechaYClienteMenu() {
        System.out.print("Ingrese la identificación del cliente: ");
        String identificacion = scanner.nextLine();

        System.out.print("Ingrese la fecha de la cita (formato: YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);

        if (gestorCitas.eliminarCitaPorFechaYCliente(fecha, identificacion)) {
            System.out.println("Cita eliminada exitosamente.");
        } else {
            System.out.println("No se encontró ninguna cita para el cliente en la fecha especificada.");
        }
    }

    private void mostrarTodasLasCitas() {
    ArrayList<Cita> citas = gestorCitas.obtenerCitas();

    if (citas.isEmpty()) {
        System.out.println("No hay citas registradas.");
    } else {
        System.out.println("\n--- Lista de Todas las Citas ---");
        for (Cita cita : citas) {
            System.out.println("Cliente: " + cita.getCliente().getNombreCompleto());
            System.out.println("Identificación: " + cita.getCliente().getIdentificacion());
            System.out.println("Fecha: " + cita.getFecha());
            System.out.println("Hora: " + cita.getHora());
            System.out.println("--------------------------");
        }
    }
}

    public static void main(String[] args) {
        GestorCitas gestorCitas = new GestorCitas();
        Menu menu = new Menu(gestorCitas);
        menu.mostrarMenu();
    }
}
