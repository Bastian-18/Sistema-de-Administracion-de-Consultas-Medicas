package clinica;

import java.util.ArrayList;
import java.util.List;

public class SistemaClinico {
    
    List<Cliente> clientes;
    List<Doctor> doctores;
    List<Consulta> consultas;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(List<Doctor> doctores) {
        this.doctores = doctores;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

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

