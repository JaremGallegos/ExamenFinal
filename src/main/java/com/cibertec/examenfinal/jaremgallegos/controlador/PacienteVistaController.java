package com.cibertec.examenfinal.jaremgallegos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.examenfinal.jaremgallegos.modelo.Paciente;
import com.cibertec.examenfinal.jaremgallegos.servicio.PacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacienteVistaController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("paciente", new Paciente());  
        return "pacientes";  
    }
}
