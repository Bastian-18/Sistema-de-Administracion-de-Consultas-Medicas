package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
@View(members =
    "nombre_cliente;" +
    "ruc;" +
    "email;" +
    "telefono;" +
    "direccion;" +
    "estado;"
)
public class Cliente extends BaseEntity{

    @Required
    @Column(name = "nombre_cliente", nullable = false)
    private String nombre_cliente;

    @Required
    @Column(name = "ruc", nullable = false)
    private String ruc;

    @Required
    @Column(name = "email", nullable = false)
    private String email;

    @Required
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Required
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Required
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private Estado estado;

}
