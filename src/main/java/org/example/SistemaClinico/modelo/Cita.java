package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import org.openxava.annotations.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Views({
    @View(name="Simple", members="fecha, hora, cliente, doctor, estado"),
    @View(name="Completa", members="fecha, hora, cliente, doctor, estado, notas")
})


@Tab(properties="fecha, hora, cliente.nombre, cliente.apellido, doctor.nombre, doctor.apellido, estado")
public class Cita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcita")
    @ReadOnly
    @Hidden
    private int idCita;
    
    @Required
    @Column(name = "fecha")
    @DefaultValueCalculator(org.openxava.calculators.CurrentDateCalculator.class)
    private Date fecha;
    
    @Required
    @Column(length = 5)
    @javax.validation.constraints.Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$", message = "La hora debe tener el formato HH:mm (ej. 14:30)")
    private String hora;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id")
    @ReferenceView("Busqueda")
    @Required
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id")
    @ReferenceView("Busqueda")
    @Required
    private Doctor doctor;
    
    @Required
    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    @DefaultValueCalculator(org.example.SistemaClinico.modelo.calculators.EstadoCitaDefaultCalculator.class)
    private EstadoCita estado;
    
    @Stereotype("MEMO")
    @Column(length = 500)
    private String notas;
    
    public Cita() {}
    
    @Override
    public String toString() {
        return (fecha != null ? fecha.toString() : "") + " " + hora + " - " + 
               (cliente != null ? cliente.getNombre() + " " + cliente.getApellido() : "") + 
               " con " + (doctor != null ? doctor.getNombre() + " " + doctor.getApellido() : "");
    }
}

