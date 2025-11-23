package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SistemaClinico {
    
    List<Cliente> clientes;
    List<Doctor> doctores;
    List<Consulta> consultas;

    @Override
    public String toString() {
        return "SistemaClinico{" +
                "clientes=" + clientes +
                ", doctores=" + doctores +
                ", consultas=" + consultas +
                '}';
    }

    public SistemaClinico(List<Cliente> clientes, List<Doctor> doctores, List<Consulta> consultas) {
        this.clientes = clientes;
        this.doctores = doctores;
        this.consultas = consultas;
    }
}

