package org.example.Uam_Fia.modelo;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique "Simple"
    members="numero, nombre" // Muestra únicamente numero y nombre en la misma línea
)
public class Cliente {

    @Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=32)
    String oid;

    @Column(length=6) @Required
    int numero;

    @Column(length=50) @Required
    String nombre;

    @TextArea
    String direccion;

}

