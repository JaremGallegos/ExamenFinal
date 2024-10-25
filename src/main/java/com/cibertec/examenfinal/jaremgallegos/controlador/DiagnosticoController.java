package com.cibertec.examenfinal.jaremgallegos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Diagnostico registrarDiagnostico(@RequestBody Diagnostico diagnostico) {
        return diagnosticoService.registrarDiagnostico(diagnostico);
    }
}
