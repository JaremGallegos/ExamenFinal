package com.cibertec.examenfinal.jaremgallegos.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.examenfinal.jaremgallegos.modelo.Diagnostico;
import com.cibertec.examenfinal.jaremgallegos.repositorio.DiagnosticoRepository;

@Service
public class DiagnosticoService {
    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    public List<Diagnostico> listarDiagnosticos() {
        return diagnosticoRepository.findAll();
    }

    public Diagnostico registrarDiagnostico(Diagnostico diagnostico) {
        return diagnosticoRepository.save(diagnostico);
    }

    public Optional<Diagnostico> obtenerDiagnosticoPorId(Long id) {
        return diagnosticoRepository.findById(id);
    }
}