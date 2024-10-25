package com.cibertec.examenfinal.jaremgallegos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.examenfinal.jaremgallegos.modelo.HistorialOdontologico;
import com.cibertec.examenfinal.jaremgallegos.servicio.HistorialOdontologicoService;

@RestController
@RequestMapping("/api/historiales")
public class HistorialOdontologicoController {
    @Autowired
    private HistorialOdontologicoService historialService;

    @GetMapping
    public List<HistorialOdontologico> listarHistoriales() {
        return historialService.listarHistoriales();
    }

    @GetMapping("/paciente/{pacienteId}")
    public List<HistorialOdontologico> listarHistorialesPorPaciente(@PathVariable Long pacienteId) {
        return historialService.listarHistorialesPorPaciente(pacienteId);
    }

    @PostMapping
    public HistorialOdontologico registrarHistorial(@ModelAttribute HistorialOdontologico historial) {
        return historialService.registrarHistorial(historial);
    }
}
