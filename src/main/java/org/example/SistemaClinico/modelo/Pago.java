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
    @DescriptionsList(
        descriptionProperties = "fecha, hora, cliente.nombre, cliente.apellido, totalCosto",
        order = "fecha DESC, hora DESC"
    )
    @Required
    @NoCreate
    @NoModify
    private Consulta consulta;
    
    @Required
    @Column(length = 20)
    @DisplaySize(15)
    private String fechaPago;
    
    @Required
    @Stereotype("MONEY")
    @Column(precision = 10, scale = 2)
    private BigDecimal monto;
    
    @Required
    @Column(length = 50)
    private String metodoPago;
    
    @Required
    @Column(length = 50)
    private String estado;
    
    @Column(length = 100)
    @DisplaySize(40)
    private String numeroReferencia;
    
    @Stereotype("MEMO")
    @Column(length = 500)
    private String notas;
    
    public Pago() {}
    
    @Override
    public String toString() {
        return "Pago " + fechaPago + " - " + 
               (monto != null ? monto.toString() : "0.00") + " - " + 
               (metodoPago != null ? metodoPago : "");
    }
}

