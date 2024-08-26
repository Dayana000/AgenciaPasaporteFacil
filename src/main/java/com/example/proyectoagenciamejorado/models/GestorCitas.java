package com.example.proyectoagenciamejorado.models;


import java.util.ArrayList;
import java.time.LocalDate;

public class GestorCitas {

    private ArrayList<Cita> citas = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public boolean eliminarCitaPorFechaYCliente(LocalDate fecha, String identificacion) {
            
        Cita citaAEliminar = encontrarCitaPorFechaYCliente(fecha, identificacion);

        if (citaAEliminar != null) {

            citas.remove(citaAEliminar);
            return true;
        }
    
        return false; 
    }

    public Cita encontrarCitaPorFechaYCliente(LocalDate fecha, String identificacion) {
        
        Cliente cliente = encontrarClientePorIdentificacion(identificacion);

        for (Cita cita : citas) {
            if (cita.getFecha().equals(fecha) && cita.getCliente().equals(cliente)) {
                return cita; 
            }
        }
        return null; 
    }

    public Cliente encontrarClientePorIdentificacion(String identificacion) {

        for (Cliente cliente : clientes) {
            System.out.println("Cliente encontrado: Identificación = " + cliente.getIdentificacion());
            if (cliente.getIdentificacion().equals(identificacion)) {
                System.out.println("encontrado");
                return cliente; // Retornar el cliente encontrado
            }
        }
        return null; 
    }

    public boolean actualizarCliente(String identificacion, String nombre, String correo) {
        Cliente cliente = encontrarClientePorIdentificacion(identificacion);
            if (cliente != null) {
                cliente.setNombreCompleto(nombre);
                cliente.setCorreoElectronico(correo);
                return true; // Retornar true si la actualización fue exitosa
            }
    
        return false; // Retornar false si no se encontró el cliente
    }

    public boolean verificarClienteYFecha(String identificacion, LocalDate fecha) {
        // Verificar que la fecha no sea nula
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula.");
        }
        for (Cliente cliente : clientes) {
            if(cliente.getIdentificacion().equals(identificacion)){
                // Recorrer la lista de citas del cliente para verificar si ya existe una cita en la fecha dada
                for (Cita cita : citas) {
                    if (cita.getCliente().equals(cliente) && cita.getFecha().equals(fecha)) {
                        return true; 
                    }
                }
            }
        }
        return false; 
    }

    public ArrayList<Cita> obtenerCitas() {
    return citas;
    }

    public ArrayList<Cliente> obtenerClientes(){
        return clientes;
    }
}
