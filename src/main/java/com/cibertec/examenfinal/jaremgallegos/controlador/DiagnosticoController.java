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

import com.cibertec.examenfinal.jaremgallegos.modelo.Diagnostico;
import com.cibertec.examenfinal.jaremgallegos.servicio.DiagnosticoService;

@RestController
@RequestMapping("/api/diagnosticos")
public class DiagnosticoController {
    @Autowired
    private DiagnosticoService diagnosticoService;

    @GetMapping
    public List<Diagnostico> listarDiagnosticos() {
        return diagnosticoService.listarDiagnosticos();
    }

    @PostMapping
    public ResponseEntity<String> registrarDiagnostico(@ModelAttribute Diagnostico diagnostico) {
        Diagnostico nuevoDiagnostico = diagnosticoService.registrarDiagnostico(diagnostico);
        return ResponseEntity.ok("Diagnóstico registrado correctamente" + nuevoDiagnostico.getDescripcion());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diagnostico> obtenerDiagnosticoPorId(@PathVariable Long id) {
        Optional<Diagnostico> diagnosticoOpt = diagnosticoService.obtenerDiagnosticoPorId(id);
        return diagnosticoOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
