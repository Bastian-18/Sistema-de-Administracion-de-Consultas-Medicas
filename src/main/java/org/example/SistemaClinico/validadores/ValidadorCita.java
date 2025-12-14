package org.example.SistemaClinico.validadores;

import org.example.SistemaClinico.modelo.*;
import org.openxava.util.*;
import org.openxava.validators.*;
import javax.persistence.*;
import org.openxava.jpa.XPersistence;
import java.util.Date;

public class ValidadorCita implements IValidator {

    private int idCita;
    private Date fecha;
    private String hora;
    private Doctor doctor;

    public void validate(Messages errors) throws Exception {
        if (fecha == null || hora == null || doctor == null) return;

        EntityManager em = XPersistence.getManager();
        Query query = em.createQuery("select count(c) from Cita c where c.doctor.idDoctor = :idDoctor and c.fecha = :fecha and c.hora = :hora and c.idCita <> :idCita");
        query.setParameter("idDoctor", doctor.getIdDoctor());
        query.setParameter("fecha", fecha);
        query.setParameter("hora", hora);
        query.setParameter("idCita", idCita);
        
        Long count = (Long) query.getSingleResult();
        if (count > 0) {
            errors.add("cita_duplicada_doctor", doctor.getNombre() + " " + doctor.getApellido(), fecha, hora);
        }
    }

    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
}
