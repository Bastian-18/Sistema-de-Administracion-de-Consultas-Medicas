package org.example.SistemaClinico.modelo.calculators;

import org.example.SistemaClinico.modelo.EstadoPago;
import org.openxava.calculators.ICalculator;

public class EstadoPagoDefaultCalculator implements ICalculator {
    @Override
    public Object calculate() throws Exception {
        return EstadoPago.PENDIENTE;
    }
}

