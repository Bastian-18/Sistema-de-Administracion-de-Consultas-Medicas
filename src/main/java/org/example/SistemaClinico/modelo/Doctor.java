package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.ReadOnly;

@Getter
@Setter
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ReadOnly
    private int idDoctor;

    private String nombre;
    private String apellido;
    private String especialidad;
    private String numerolicencia;
    private String telefono;

    public Doctor() {}

    public Doctor(String nombre, String apellido, String especialidad, String numerolicencia, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.numerolicencia = numerolicencia;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", numerolicencia='" + numerolicencia + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
