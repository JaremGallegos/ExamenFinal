package com.cibertec.examenfinal.jaremgallegos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.examenfinal.jaremgallegos.modelo.HistorialOdontologico;
import com.cibertec.examenfinal.jaremgallegos.servicio.DiagnosticoService;
import com.cibertec.examenfinal.jaremgallegos.servicio.HistorialOdontologicoService;
import com.cibertec.examenfinal.jaremgallegos.servicio.OdontologoService;
import com.cibertec.examenfinal.jaremgallegos.servicio.PacienteService;

import java.util.List;

@Controller
@RequestMapping("/historiales")
public class HistorialOdontologicoVistaController {
    @Autowired
    private HistorialOdontologicoService historialOdontologicoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private DiagnosticoService  diagnosticoService;

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping
    public String listarHistoriales(Model model) {
        List<HistorialOdontologico> historial = historialOdontologicoService.listarHistoriales();
        model.addAttribute("historiales", historial);
        model.addAttribute("historialOdontologico", new HistorialOdontologico());
        model.addAttribute("pacientes", pacienteService.listarPacientes());
        model.addAttribute("diagnosticos", diagnosticoService.listarDiagnosticos()); 
        model.addAttribute("odontologos", odontologoService.listarOdontologos());
        return "historial";
    }
}
