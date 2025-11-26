package clinica;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@Entity

public class Doctor {
    @Id
    private int idDoctor;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String telefono;
    private String email;

    public Doctor(int idDoctor, String nombre, String apellido, String especialidad, String telefono, String email) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
    }
    public Doctor() {
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

