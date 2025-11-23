package clinica;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Doctor {
    
    String nombre;
    String apellido;
    String especialidad;
    String numeroLicencia;
    String telefono;

    public Doctor(String nombre, String apellido, String especialidad, String numeroLicencia, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.numeroLicencia = numeroLicencia;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", numeroLicencia='" + numeroLicencia + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

}

