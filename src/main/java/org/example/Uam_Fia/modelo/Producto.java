package org.example.Uam_Fia.modelo;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import lombok.*;

@Entity @Getter @Setter
public class Producto {

    @Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=32)
    String oid;

    @Column(length=10) @Required
    int numero;

    @Column(length=50) @Required
    String descripcion;

    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList
    Categoria categoria;

    @Column(length=10)
    double precio;

    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList
    Autor autor;

}

