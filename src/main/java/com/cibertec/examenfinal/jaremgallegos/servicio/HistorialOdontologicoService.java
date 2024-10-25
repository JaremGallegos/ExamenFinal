package com.cibertec.examenfinal.jaremgallegos.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.examenfinal.jaremgallegos.modelo.HistorialOdontologico;
import com.cibertec.examenfinal.jaremgallegos.repositorio.HistorialOdontologicoRepository;

@Service
public class HistorialOdontologicoService {
    @Autowired
    private HistorialOdontologicoRepository historialRepository;

    public List<HistorialOdontologico> listarHistoriales() {
        return historialRepository.findAll();
    }

    public List<HistorialOdontologico> listarHistorialesPorPaciente(Long pacienteId) {
        return historialRepository.findByPacienteId(pacienteId);
    }

    public HistorialOdontologico registrarHistorial(HistorialOdontologico historial) {
        return historialRepository.save(historial);
    }
}
