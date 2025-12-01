package org.example.SistemaClinico.reportes.acciones;

import net.sf.jasperreports.engine.JRDataSource;
import org.openxava.actions.JasperReportBaseAction;

import java.util.Map;

public class ImprimirPagosAction extends JasperReportBaseAction {

    @Override
    protected JRDataSource getDataSource() throws Exception {
        // Retornar null para que JasperReports use la query SQL embebida en el reporte
        return null;
    }

    @Override
    protected String getJRXML() throws Exception {
        return "PagosReport.jrxml";
    }

    @Override
    protected Map getParameters() throws Exception {
        return null;
    }
}

