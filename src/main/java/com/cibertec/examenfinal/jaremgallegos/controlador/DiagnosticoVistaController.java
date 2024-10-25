package com.cibertec.examenfinal.jaremgallegos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.examenfinal.jaremgallegos.modelo.Diagnostico;
import com.cibertec.examenfinal.jaremgallegos.servicio.DiagnosticoService;

import java.util.List;

@Controller
@RequestMapping("/diagnosticos")
public class DiagnosticoVistaController {
    @Autowired
    private DiagnosticoService diagnosticoService;

    @GetMapping
    public String listarDiagnosticos(Model model) {
        List<Diagnostico> diagnosticos = diagnosticoService.listarDiagnosticos();
        model.addAttribute("diagnosticos", diagnosticos);
        model.addAttribute("diagnostico", new Diagnostico());  
        return "diagnosticos";
    }
}