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
    @View(name="Simple", members="fecha, hora, cliente, doctor, estado"),
    @View(name="Completa", members="fecha, hora, cliente, doctor, motivo, estado, costo; tratamientos; pagos"),
    @View(name="Busqueda", members="fecha, hora, cliente, doctor, estado, costo")
})
@Tab(properties="fecha, hora, cliente.nombre, cliente.apellido, doctor.nombre, doctor.apellido, estado, costo")
@org.openxava.annotations.EntityValidator(
    value=org.example.SistemaClinico.validadores.ValidadorModificacionConsulta.class,
    properties= { @PropertyValue(name="estado"), @PropertyValue(name="idConsulta") }
)
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idconsulta")
    @ReadOnly
    @Hidden
    private int idConsulta;

    @Required
    @Stereotype("DATE")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    @DefaultValueCalculator(org.openxava.calculators.CurrentDateCalculator.class)
    private Date fecha;
    
    @Required
    @Stereotype("TIME")
    @Column(length = 20)
    @DisplaySize(10)
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


    @Stereotype("MEMO")
    @Column(length = 500)
    private String motivo;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    @DisplaySize(20)
    @DefaultValueCalculator(org.example.SistemaClinico.modelo.calculators.EstadoConsultaDefaultCalculator.class)
    private EstadoConsulta estado;
    
    @Stereotype("MONEY")
    @Min(value = 0, message = "El costo no puede ser negativo")
    @Column(name = "costo", precision = 10, scale = 2)
    @DisplaySize(15)
    private BigDecimal costo;
    
    @OneToMany(mappedBy="consulta", cascade=CascadeType.ALL)
    @ListProperties("nombre, duracion")
    private java.util.Collection<Tratamiento> tratamientos;
    
    @OneToMany(mappedBy="consulta", cascade=CascadeType.ALL)
    @ListProperties("fechaPago, monto, metodoPago, estado")
    private java.util.Collection<Pago> pagos;

    public Consulta() {}

    public Consulta(Date fecha, String hora, Cliente cliente, Doctor doctor, String motivo, EstadoConsulta estado, BigDecimal costo) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.doctor = doctor;
        this.motivo = motivo;
        this.estado = estado;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "idConsulta=" + idConsulta +
                ", fecha=" + (fecha != null ? fecha.toString() : "") +
                ", hora='" + hora + '\'' +
                ", cliente=" + cliente +
                ", doctor=" + doctor +
                ", motivo='" + motivo + '\'' +
                ", estado='" + estado + '\'' +
                ", costo=" + costo +
                '}';
    }
}
