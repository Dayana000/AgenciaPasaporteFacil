package com.example.proyectoagenciamejorado.models;

import java.util.ArrayList;

public class GestorClientes {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    // Método para agregar un cliente
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    // Método para obtener todos los clientes
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    // Método para buscar un cliente por identificación
    public Cliente buscarClientePorIdentificacion(String identificacion) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente, devuelve null
    }

    // Método para actualizar un cliente
    public boolean actualizarCliente(Cliente clienteActualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getIdentificacion().equals(clienteActualizado.getIdentificacion())) {
                clientes.set(i, clienteActualizado); // Actualiza el cliente
                return true;
            }
        }
        return false; // Si no se encuentra el cliente, no se actualiza
    }

    // Método para eliminar un cliente por identificación
    public boolean eliminarCliente(String identificacion) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdentificacion().equals(identificacion)) {
                clientes.remove(i); // Elimina el cliente
                return true;
            }
        }
        return false; // Si no se encuentra el cliente, no se elimina
    }
}