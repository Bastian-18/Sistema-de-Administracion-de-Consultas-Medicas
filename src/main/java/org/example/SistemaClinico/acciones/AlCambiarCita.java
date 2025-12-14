package org.example.SistemaClinico.acciones;

import org.openxava.actions.OnChangePropertyBaseAction;
import org.openxava.jpa.XPersistence;
import org.example.SistemaClinico.modelo.Cita;
import org.example.SistemaClinico.modelo.Cliente;
import org.example.SistemaClinico.modelo.Doctor;
import java.util.Date;

public class AlCambiarCita extends OnChangePropertyBaseAction {

    public void execute() throws Exception {
        if (getNewValue() == null) return;
        
        int idCita = (Integer) getNewValue();
        Cita cita = XPersistence.getManager().find(Cita.class, idCita);
        
        if (cita != null) {
            // Auto-completar datos desde la Cita
            getView().setValue("fecha", cita.getFecha());
            getView().setValue("hora", cita.getHora());
            
            // Para Cliente
            if (cita.getCliente() != null) {
                // Intentamos llenar DNI primero que es clave de búsqueda
                try {
                    getView().setValue("cliente.dni", cita.getCliente().getDni());
                } catch (Exception e) {} // Si falla, ignorar
                
                // Forzar el ID (clave oculta)
                getView().setValue("cliente.idCliente", cita.getCliente().getIdCliente());
            }

            // Para Doctor
            if (cita.getDoctor() != null) {
                // Intentamos llenar ID y Licencia
                getView().setValue("doctor.idDoctor", cita.getDoctor().getIdDoctor());
                try {
                   if (cita.getDoctor().getNumerolicencia() != null) {
                       getView().setValue("doctor.numerolicencia", cita.getDoctor().getNumerolicencia());
                   }
                } catch (Exception e) {}
            }
            
            // Copiar notas al motivo si está vacío
            String motivoActual = (String) getView().getValue("motivo");
            if ((motivoActual == null || motivoActual.trim().isEmpty()) && cita.getNotas() != null) {
                getView().setValue("motivo", cita.getNotas());
            }
            
            addMessage("Datos cargados desde la Cita seleccionada");
        }
    }
}
