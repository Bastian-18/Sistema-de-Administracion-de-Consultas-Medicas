package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import org.openxava.annotations.*;
import java.math.BigDecimal;

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
    @DescriptionsList(
        descriptionProperties = "fecha, hora, cliente.nombre, cliente.apellido",
        order = "fecha DESC, hora DESC"
    )
    @Required
    @NoCreate
    @NoModify
    private Consulta consulta;
    
    @Required
    @Column(length = 20)
    @DisplaySize(15)
    private String fechaEmision;
    
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
        return "Receta " + fechaEmision + " - " + 
               (consulta != null && consulta.getCliente() != null ? 
                consulta.getCliente().getNombre() + " " + consulta.getCliente().getApellido() : "");
    }
}

