package org.example.SistemaClinico.modelo.calculators;

import org.example.SistemaClinico.modelo.EstadoCita;
import org.openxava.calculators.ICalculator;

public class EstadoCitaDefaultCalculator implements ICalculator {
    @Override
    public Object calculate() throws Exception {
        return EstadoCita.PROGRAMADA;
    }
}

