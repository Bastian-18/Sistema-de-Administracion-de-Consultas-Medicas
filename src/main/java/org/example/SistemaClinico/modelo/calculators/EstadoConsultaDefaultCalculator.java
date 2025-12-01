package org.example.SistemaClinico.modelo.calculators;

import org.example.SistemaClinico.modelo.EstadoConsulta;
import org.openxava.calculators.ICalculator;

public class EstadoConsultaDefaultCalculator implements ICalculator {
    @Override
    public Object calculate() throws Exception {
        return EstadoConsulta.PENDIENTE;
    }
}

