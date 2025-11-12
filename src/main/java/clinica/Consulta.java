package clinica;

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTotalCosto() {
        return TotalCosto;
    }

    public void setTotalCosto(String totalCosto) {
        TotalCosto = totalCosto;
    }
}

