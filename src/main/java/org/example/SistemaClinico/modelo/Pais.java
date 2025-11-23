package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
@Getter
@Setter
@View(members = "nombrePais;")
//Las relaciones OneToMany a Municipio e ItemDeclaracion ya están declarados
//Están como comentarios hasta que esas tablas sean terminadas

public class Pais extends BaseEntity{
    @Required
    @Column(name = "nombre_pais", length = 50, nullable = false)
    private String nombrePais;
    //@OneToMany(mappedBy = "paisMunicipio", cascade = CascadeType.ALL)
    //private List<Municipio> municipios;
    //@OneToMany(mappedBy = "paisItemDeclaracion", cascade = CascadeType.ALL)
    //private List<ItemDeclaracion> itemsDeclaracion;
}
