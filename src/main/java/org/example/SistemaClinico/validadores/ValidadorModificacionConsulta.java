package org.example.SistemaClinico.validadores;

import org.example.SistemaClinico.modelo.*;
import org.openxava.util.*;
import org.openxava.validators.*;
import javax.persistence.*;
import org.openxava.jpa.XPersistence;

public class ValidadorModificacionConsulta implements IValidator {

    private int idConsulta;
    private EstadoConsulta estado;

    public void validate(Messages errors) throws Exception {
        if (idConsulta == 0) return; // Es nuevo, no validar

        // Obtener el estado ACTUAL en la base de datos (antes de esta modificación)
        EntityManager em = XPersistence.getManager();
        Query query = em.createQuery("select c.estado from Consulta c where c.idConsulta = :id");
        query.setParameter("id", idConsulta);
        
        try {
            EstadoConsulta estadoAnterior = (EstadoConsulta) query.getSingleResult();
            
            // Si estaba COMPLETADA, NO permitir cambios
            if (estadoAnterior == EstadoConsulta.COMPLETADA) {
                errors.add("consulta_bloqueada_edicion", estadoAnterior);
            }
        } catch (NoResultException ex) {
            // No existe (raro si id!=0), ignorar
        }
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }
    
    public EstadoConsulta getEstado() {
        return estado;
    }

    public void setEstado(EstadoConsulta estado) {
        this.estado = estado;
    }
}
