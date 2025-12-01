package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import org.openxava.annotations.*;

@Getter
@Setter
@Entity
@Views({
    @View(name="Simple", members="nombre, apellido, especialidad, telefono"),
    @View(name="Completa", members="nombre, apellido, especialidad, numerolicencia, telefono"),
    @View(name="Busqueda", members="nombre, apellido, especialidad")
})
@Tab(properties="nombre, apellido, especialidad, numerolicencia, telefono", 
     defaultOrder="${nombre} asc, ${apellido} asc")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddoctor")
    @ReadOnly
    @Hidden
    private int idDoctor;

    @Required
    @Column(length = 100)
    @DisplaySize(30)
    private String nombre;
    
    @Required
    @Column(length = 100)
    @DisplaySize(30)
    private String apellido;
    
    @Required
    @Column(length = 100)
    @DisplaySize(30)
    private String especialidad;
    
    @Column(length = 50)
    @DisplaySize(20)
    private String numerolicencia;
    
    @Column(length = 50)
    @DisplaySize(15)
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
