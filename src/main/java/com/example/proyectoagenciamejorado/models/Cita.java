package com.example.proyectoagenciamejorado.models;

import java.time.LocalDate;

public class Cita {

    private Cliente cliente;
    private LocalDate fecha;
    private String hora;

    public Cita(Cliente cliente, LocalDate fecha, String hora) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getHora() {

        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    
}
