package org.example.SistemaClinico.reportes.acciones;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import org.openxava.actions.JasperReportBaseAction;

import java.util.Map;

public class ImprimirPagosAction extends JasperReportBaseAction {

    @Override
    protected JRDataSource getDataSource() throws Exception {
        return new JREmptyDataSource();
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

