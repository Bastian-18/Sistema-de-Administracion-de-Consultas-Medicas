package org.example.SistemaClinico.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Min;
import org.openxava.annotations.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Views({
    @View(name="Simple", members="consulta, fechaPago, monto, metodoPago, estado"),
    @View(name="Completa", members="consulta, fechaPago, monto, metodoPago, estado, numeroReferencia, notas")
})
@Tab(properties="fechaPago, consulta.cliente.nombre, consulta.cliente.apellido, monto, metodoPago, estado")
public class Pago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpago")
    @ReadOnly
    @Hidden
    private int idPago;
    
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
    @Column(name = "fechapago")
    @DefaultValueCalculator(org.openxava.calculators.CurrentDateCalculator.class)
    private Date fechaPago;
    
    @Required
    @Stereotype("MONEY")
    @Min(value = 0, message = "El monto no puede ser negativo")
    @Column(precision = 10, scale = 2)
    private BigDecimal monto;
    
    @Required
    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private MetodoPago metodoPago;
    
    @Required
    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    @DefaultValueCalculator(org.example.SistemaClinico.modelo.calculators.EstadoPagoDefaultCalculator.class)
    private EstadoPago estado;
    
    @Column(length = 100)
    @DisplaySize(40)
    private String numeroReferencia;
    
    @Stereotype("MEMO")
    @Column(length = 500)
    private String notas;
    
    public Pago() {}
    
    @Override
    public String toString() {
        return "Pago " + (fechaPago != null ? fechaPago.toString() : "") + " - " + 
               (monto != null ? monto.toString() : "0.00") + " - " + 
               (metodoPago != null ? metodoPago : "");
    }
}

