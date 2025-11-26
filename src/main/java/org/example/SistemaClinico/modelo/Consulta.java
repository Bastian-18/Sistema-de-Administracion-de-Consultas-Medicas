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
    @View(name="Simple", members="fecha, hora, cliente, doctor, estado"),
    @View(name="Completa", members="fecha, hora, cliente, doctor, motivo, estado, totalCosto")
})
@Tab(properties="fecha, hora, cliente.nombre, cliente.apellido, doctor.nombre, doctor.apellido, estado, totalCosto")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idconsulta")
    @ReadOnly
    @Hidden
    private int idConsulta;

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

    @Stereotype("MEMO")
    @Column(length = 500)
    private String motivo;
    
    @Column(length = 50)
    @DisplaySize(20)
    private String estado;
    
    @Stereotype("MONEY")
    @Column(name = "totalcosto", precision = 10, scale = 2)
    private BigDecimal totalCosto;

    public Consulta() {}

    public Consulta(String fecha, String hora, Cliente cliente, Doctor doctor, String motivo, String estado, BigDecimal totalCosto) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.doctor = doctor;
        this.motivo = motivo;
        this.estado = estado;
        this.totalCosto = totalCosto;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "idConsulta=" + idConsulta +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", cliente=" + cliente +
                ", doctor=" + doctor +
                ", motivo='" + motivo + '\'' +
                ", estado='" + estado + '\'' +
                ", totalCosto=" + totalCosto +
                '}';
    }
}
