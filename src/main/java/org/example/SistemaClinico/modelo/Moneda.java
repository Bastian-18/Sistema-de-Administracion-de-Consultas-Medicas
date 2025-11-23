package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "moneda")
@Getter
@Setter
@View(members = "nombreMoneda;")
//Las relación OneToMany a Expediente ya están declarada
//Está como comentario hasta que esa tablas sean terminada

public class Moneda extends BaseEntity{
    @Required
    @Column(name = "nombre_moneda", length = 50, nullable = false)
    private String nombreMoneda;
    //@OneToMany(mappedBy = "moneda", cascade = CascadeType.ALL)
    //private List<Expediente> expedientes;
}