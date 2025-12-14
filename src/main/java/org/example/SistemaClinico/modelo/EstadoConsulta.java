package org.example.SistemaClinico.modelo;

public enum EstadoConsulta {
    EN_ESPERA("En Espera"),
    EN_ATENCION("En Atención"),
    COMPLETADA("Completada");
    
    private final String descripcion;
    
    EstadoConsulta(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        return descripcion;
    }
}

