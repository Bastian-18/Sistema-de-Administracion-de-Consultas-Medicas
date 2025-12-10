package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import org.openxava.annotations.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Views({
    @View(name="Simple", members="consulta, fechaEmision, medicamentos"),
    @View(name="Completa", members="consulta, fechaEmision, medicamentos, dosis, frecuencia, duracion, instrucciones")
})
@Tab(properties="fechaEmision, consulta.cliente.nombre, consulta.cliente.apellido, consulta.doctor.nombre, medicamentos")
public class Receta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreceta")
    @ReadOnly
    @Hidden
    private int idReceta;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "consulta_id")
    @ReferenceView("Busqueda")
    @Required
    @NoCreate
    @NoModify
    private Consulta consulta;
    
    @Required
    @Stereotype("DATE")
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaemision")
    @DefaultValueCalculator(org.openxava.calculators.CurrentDateCalculator.class)
    private Date fechaEmision;
    
    @Required
    @Column(length = 200)
    @DisplaySize(50)
    private String medicamentos;
    
    @Column(length = 100)
    @DisplaySize(30)
    private String dosis;
    
    @Column(length = 100)
    @DisplaySize(30)
    private String frecuencia;
    
    @Column(length = 50)
    @DisplaySize(20)
    private String duracion;
    
    @Stereotype("MEMO")
    @Column(length = 500)
    private String instrucciones;
    
    public Receta() {}




    @Override
    public String toString() {
        return "Receta " + (fechaEmision != null ? fechaEmision.toString() : "") + " - " +
                (consulta != null && consulta.getCliente() != null ?
                        consulta.getCliente().getNombre() + " " + consulta.getCliente().getApellido() : "");
    }
}

