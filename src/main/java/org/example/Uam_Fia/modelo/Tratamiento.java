package clinica;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Tratamiento {
    
    String nombre;
    String descripcion;
    String duracion;
    String medicamentos;
    Consulta consulta;

    public Tratamiento(String nombre, String descripcion, String duracion, String medicamentos, Consulta consulta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.medicamentos = medicamentos;
        this.consulta = consulta;
    }

    @Override
    public String toString() {
        return "Tratamiento{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracion='" + duracion + '\'' +
                ", medicamentos='" + medicamentos + '\'' +
                ", consulta=" + consulta +
                '}';
    }

}

