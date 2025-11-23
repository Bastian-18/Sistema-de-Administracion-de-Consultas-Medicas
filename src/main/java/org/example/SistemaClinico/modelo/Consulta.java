package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.ReadOnly;

@Getter
@Setter
@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ReadOnly

    private int idConsulta;

    private String fecha;
    private String hora;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Doctor doctor;

    private String motivo;
    private String estado;
    private String totalCosto;

    public Consulta() {}

    public Consulta(String fecha, String hora, Cliente cliente, Doctor doctor, String motivo, String estado, String totalCosto) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.doctor = doctor;
        this.motivo = motivo;
        this.estado = estado;
        this.totalCosto = totalCosto;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "idConsulta=" + idConsulta +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", cliente=" + cliente +
                ", doctor=" + doctor +
                ", motivo='" + motivo + '\'' +
                ", estado='" + estado + '\'' +
                ", totalCosto='" + totalCosto + '\'' +
                '}';
    }
}
