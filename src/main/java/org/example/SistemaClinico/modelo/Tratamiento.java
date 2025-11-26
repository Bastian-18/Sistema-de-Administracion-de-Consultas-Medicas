package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import org.openxava.annotations.*;

@Getter
@Setter
@Entity
@Views({
    @View(name="Simple", members="consulta, nombre, duracion"),
    @View(name="Completa", members="consulta, nombre, descripcion, duracion, medicamentos")
})
@Tab(properties="nombre, consulta.fecha, consulta.cliente.nombre, consulta.cliente.apellido, duracion")
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtratamiento")
    @ReadOnly
    @Hidden
    private int idTratamiento;

    @Required
    @Column(length = 100)
    @DisplaySize(40)
    private String nombre;
    
    @Stereotype("MEMO")
    @Column(length = 500)
    private String descripcion;
    
    @Column(length = 50)
    @DisplaySize(20)
    private String duracion;
    
    @Stereotype("MEMO")
    @Column(length = 500)
    private String medicamentos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "consulta_id")
    @DescriptionsList(
        descriptionProperties = "fecha, hora, cliente.nombre, cliente.apellido",
        order = "fecha DESC, hora DESC"
    )
    @Required
    @NoCreate
    @NoModify
    private Consulta consulta;

    public Tratamiento() {}

    public Tratamiento(String nombre, String descripcion, String duracion, String medicamentos, Consulta consulta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.medicamentos = medicamentos;
        this.consulta = consulta;
    }

    @Override
    public String toString() {
        return "Tratamiento{" +
                "idTratamiento=" + idTratamiento +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracion='" + duracion + '\'' +
                ", medicamentos='" + medicamentos + '\'' +
                ", consulta=" + consulta +
                '}';
    }
}
