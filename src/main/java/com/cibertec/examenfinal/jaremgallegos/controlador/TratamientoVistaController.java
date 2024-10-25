package com.cibertec.examenfinal.jaremgallegos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.examenfinal.jaremgallegos.modelo.Tratamiento;
import com.cibertec.examenfinal.jaremgallegos.servicio.PacienteService;
import com.cibertec.examenfinal.jaremgallegos.servicio.TratamientoService;

@Controller
@RequestMapping("/atenciones")
public class TratamientoVistaController {
    @Autowired
    private TratamientoService tratamientoService;
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String listarTratamientos(Model model) {
        model.addAttribute("tratamientos", tratamientoService.listarTratamientos());
        model.addAttribute("nuevoTratamiento", new Tratamiento());
        model.addAttribute("pacientes", pacienteService.listarPacientes());
        return "atenciones"; 
    }
}
