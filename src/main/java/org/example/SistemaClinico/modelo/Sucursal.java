package org.example.SistemaClinico.modelo;


import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Sucursal")
@Getter
@Setter
@View(members =
    "codigo;" +
    "nombre;" +
    "direccion;" +
    "telefono;"
)

public class Sucursal extends BaseEntity {

    @Required
    private String codigo;
    private String nombre;
    private String direccion;
    private String telefono;

}
