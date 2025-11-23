package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
@Getter
@Setter
@View(members =
     "nombre;")
public class Rol extends BaseEntity{


    @Required
    private String nombre;






}
