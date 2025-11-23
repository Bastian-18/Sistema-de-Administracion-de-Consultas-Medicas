package org.example.SistemaClinico.modelo;
import org.openxava.annotations.Hidden;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import org.openxava.annotations.ReadOnly;

@Getter
@Setter
@Entity
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ReadOnly
    private int idTratamiento;

    private String nombre;
    private String descripcion;
    private String duracion;
    private String medicamentos;

    @ManyToOne
    private Consulta consulta;

    public Tratamiento() {}

    public Tratamiento(String nombre, String descripcion, String duracion, String medicamentos, Consulta consulta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.medicamentos = medicamentos;
        this.consulta = consulta;
    }

    @Override
    public String toString() {
        return "Tratamiento{" +
                "idTratamiento=" + idTratamiento +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracion='" + duracion + '\'' +
                ", medicamentos='" + medicamentos + '\'' +
                ", consulta=" + consulta +
                '}';
    }
}
