package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import org.openxava.annotations.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Views({
    @View(name="Simple", members="consulta, nombre, fechaInicio, fechaFin, duracion"),
    @View(name="Completa", members="consulta, nombre, descripcion, fechaInicio, fechaFin, duracion")
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
    
    @Required
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Required
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(length = 50)
    @ReadOnly
    private String duracion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "consulta_id")
    @ReferenceView("Busqueda")
    @Required
    @NoCreate
    @NoModify
    private Consulta consulta;

    @PrePersist
    @PreUpdate
    public void calcularDuracion() {
        if (fechaInicio != null && fechaFin != null) {
            long dias = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
            if (dias < 0) {
                this.duracion = "Error: Fechas inválidas";
            } else if (dias == 0) {
                this.duracion = "1 día";
            } else if (dias < 30) {
                this.duracion = (dias + 1) + " días";
            } else if (dias < 60) {
                this.duracion = "1 mes";
            } else {
                long meses = dias / 30;
                this.duracion = meses + " meses";
            }
        }
    }

    public Tratamiento() {}

    public Tratamiento(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Consulta consulta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.consulta = consulta;
        // Calcular duración inicial
        calcularDuracion();
    }

    @Override
    public String toString() {
        return "Tratamiento{" +
                "idTratamiento=" + idTratamiento +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", duracion='" + duracion + '\'' +
                ", consulta=" + consulta +
                '}';
    }
}
