package clinica;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Consulta {
    
    String fecha;
    String hora;
    Cliente cliente;
    Doctor doctor;
    String motivo;
    String estado;
    String TotalCosto;

    public Consulta(String fecha, String hora, Cliente cliente, Doctor doctor, String motivo, String estado, String totalCosto) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.doctor = doctor;
        this.motivo = motivo;
        this.estado = estado;
        TotalCosto = totalCosto;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", cliente=" + cliente +
                ", doctor=" + doctor +
                ", motivo='" + motivo + '\'' +
                ", estado='" + estado + '\'' +
                ", TotalCosto='" + TotalCosto + '\'' +
                '}';
    }

}

