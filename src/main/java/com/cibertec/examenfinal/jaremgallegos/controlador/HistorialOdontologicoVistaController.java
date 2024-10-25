package com.cibertec.examenfinal.jaremgallegos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.examenfinal.jaremgallegos.modelo.HistorialOdontologico;
import com.cibertec.examenfinal.jaremgallegos.servicio.DiagnosticoService;

@Controller
@RequestMapping("/historiales")
public class HistorialOdontologicoVistaController {
    @Autowired
    private  DiagnosticoService  diagnosticoService;

    @GetMapping
    public String listarHistoriales(Model model) {
        model.addAttribute("historialOdontologico", new HistorialOdontologico());
        model.addAttribute("diagnosticos", diagnosticoService.listarDiagnosticos()); 
        return "historial";
    }
}
