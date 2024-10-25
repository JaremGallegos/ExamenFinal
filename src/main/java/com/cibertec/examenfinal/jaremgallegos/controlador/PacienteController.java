package com.cibertec.examenfinal.jaremgallegos.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.examenfinal.jaremgallegos.modelo.Paciente;
import com.cibertec.examenfinal.jaremgallegos.servicio.PacienteService;
import com.cibertec.examenfinal.jaremgallegos.servicio.ReporteService;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @PostMapping
    public ResponseEntity<String> registrarPaciente(@ModelAttribute Paciente paciente) {
        Paciente nuevoPaciente = pacienteService.registrarPaciente(paciente);
        String mensaje = reporteService.exportReportePDF(nuevoPaciente); 
        return ResponseEntity.ok("Paciente registrado" + mensaje);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPacientePorId(@PathVariable Long id) {
        Optional<Paciente> pacienteOpt = pacienteService.obtenerPacientePorId(id);
        return pacienteOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
