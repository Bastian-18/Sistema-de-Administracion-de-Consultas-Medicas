package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import org.openxava.annotations.*;

@Getter
@Setter
@Entity
@Views({
    @View(name="Simple", members="fecha, hora, cliente, doctor, estado"),
    @View(name="Completa", members="fecha, hora, cliente, doctor, estado, notas, recordatorio")
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
    @Column(length = 20)
    @DisplaySize(15)
    private String fecha;
    
    @Required
    @Column(length = 20)
    @DisplaySize(10)
    private String hora;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id")
    @DescriptionsList(descriptionProperties = "nombre, apellido, dni")
    @Required
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id")
    @DescriptionsList(descriptionProperties = "nombre, apellido, especialidad")
    @Required
    private Doctor doctor;
    
    @Required
    @Column(length = 50)
    private String estado;
    
    @Stereotype("MEMO")
    @Column(length = 500)
    private String notas;
    
    @Column(length = 3)
    private String recordatorio;
    
    public Cita() {}
    
    @Override
    public String toString() {
        return fecha + " " + hora + " - " + 
               (cliente != null ? cliente.getNombre() + " " + cliente.getApellido() : "") + 
               " con " + (doctor != null ? doctor.getNombre() + " " + doctor.getApellido() : "");
    }
}

