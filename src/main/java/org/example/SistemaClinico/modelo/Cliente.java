package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.openxava.annotations.*;

@Getter
@Setter
@Entity
@Views({
    @View(name="Simple", members="nombre, apellido, dni, telefono"),
    @View(name="Completa", members="nombre, apellido, dni, telefono, email"),
    @View(name="Busqueda", members="nombre, apellido, dni")
})
@Tab(properties="nombre, apellido, dni, telefono, email")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    @ReadOnly
    @Hidden
    private int idCliente;

    @Required
    @Column(length = 100)
    @DisplaySize(30)
    private String nombre;
    
    @Required
    @Column(length = 100)
    @DisplaySize(30)
    private String apellido;
    
    @Required
    @Column(length = 50, unique = true)
    @DisplaySize(20)
    @Pattern(regexp="^\\d{3}-\\d{6}-\\d{4}[A-Y]$", message="El DNI debe tener el formato 000-000000-0000A")
    private String dni;
    
    @Column(length = 50)
    @DisplaySize(15)
    private String telefono;
    
    @Column(length = 100)
    @DisplaySize(40)
    @Stereotype("EMAIL")
    private String email;

    public Cliente() {}

    public Cliente(String nombre, String apellido, String dni, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
