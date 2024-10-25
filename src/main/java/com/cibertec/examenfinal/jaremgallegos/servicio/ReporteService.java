package com.cibertec.examenfinal.jaremgallegos.servicio;

import com.cibertec.examenfinal.jaremgallegos.modelo.Paciente;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;

@Service
public class ReporteService {

    public String exportReportePDF(Paciente paciente) {
        try {
            List<Paciente> pacientes = Collections.singletonList(paciente);
            File archivo = ResourceUtils.getFile("classpath:constanciaApellido.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(archivo.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(pacientes);
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("creadoPor", "Jarem Gallegos");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);
            String rutaArchivo = "D:\\CarpetaProtegida\\CPO-2\\Proyectos-2024\\jaremgallegos\\" + paciente.getId() + "_paciente.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, rutaArchivo);
            
            return "Reporte PDF generado exitosamente en: " + rutaArchivo;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al generar el reporte PDF: " + e.getMessage();
        }
    }
}