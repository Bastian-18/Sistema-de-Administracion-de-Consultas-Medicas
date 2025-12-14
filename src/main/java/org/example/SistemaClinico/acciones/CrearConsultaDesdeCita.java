package org.example.SistemaClinico.acciones;

import org.example.SistemaClinico.modelo.*;
import org.openxava.actions.ViewBaseAction;
import org.openxava.jpa.XPersistence;
import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class CrearConsultaDesdeCita extends ViewBaseAction {

    public void execute() throws Exception {
        int idCita = 0;
        try {
            idCita = getView().getValueInt("idCita");
        } catch (Exception e) {
            // Si falla obtener idCita, intentar desde key si es detail view
            Map key = getView().getKeyValues();
            if (key != null && key.containsKey("idCita")) {
                idCita = (Integer) key.get("idCita");
            }
        }

        if (idCita == 0) {
            addError("no_cita_seleccionada");
            return;
        }

        EntityManager em = XPersistence.getManager();
        Cita cita = em.find(Cita.class, idCita);

        if (cita == null) {
            addError("cita_no_encontrada");
            return;
        }

        // Crear la Consulta
        Consulta consulta = new Consulta();
        consulta.setFecha(new Date()); // Fecha actual
        consulta.setHora(cita.getHora()); // Copiar hora
        consulta.setCliente(cita.getCliente());
        consulta.setDoctor(cita.getDoctor());
        consulta.setCita(cita);
        consulta.setEstado(EstadoConsulta.EN_ESPERA);
        
        // Copiar notas de cita a motivo de consulta si existen
        if (cita.getNotas() != null) {
             consulta.setMotivo(cita.getNotas());
        }

        em.persist(consulta);

        // Actualizar estado de la Cita
        cita.setEstado(EstadoCita.COMPLETADA);
        em.merge(cita);

        // Confirmar transacción para asegurar IDs
        em.flush();
        
        addMessage("Consulta creada exitosamente (ID: " + consulta.getIdConsulta() + ")");
        
        // Opcional: Podríamos navegar a la vista de Consulta, pero por simplicidad mostramos mensaje.
        // setNextModule("Consulta"); // Esto iría al módulo Consulta pero en modo lista o último estado.
        // Para ir al detalle específico necesitaríamos pasar parámetros.
    }
}
