package com.cibertec.examenfinal.jaremgallegos.controlador;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.examenfinal.jaremgallegos.modelo.Paciente;
import com.cibertec.examenfinal.jaremgallegos.modelo.Tratamiento;
import com.cibertec.examenfinal.jaremgallegos.servicio.PacienteService;
import com.cibertec.examenfinal.jaremgallegos.servicio.TratamientoService;

@RestController
@RequestMapping("/api/atenciones")
public class TratamientoController {
    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Tratamiento> listarTratamientos() {
        return tratamientoService.listarTratamientos();
    }

    @PostMapping
    public Tratamiento registrarTratamiento(@ModelAttribute Tratamiento tratamiento) {
        Optional<Paciente> paciente = pacienteService.obtenerPacientePorId(tratamiento.getPaciente().getId());
        if (paciente.isPresent()) {
            tratamiento.setPaciente(paciente.get());  
            return tratamientoService.registrarTratamiento(tratamiento); 
        } else {
            throw new RuntimeException("Paciente no encontrado"); 
        }
    }
}
