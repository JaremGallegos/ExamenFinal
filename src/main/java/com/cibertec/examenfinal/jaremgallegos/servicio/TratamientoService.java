package com.cibertec.examenfinal.jaremgallegos.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.examenfinal.jaremgallegos.modelo.Tratamiento;
import com.cibertec.examenfinal.jaremgallegos.repositorio.TratamientoRepository;

@Service
public class TratamientoService {
    @Autowired
    private TratamientoRepository tratamientoRepository;
    

    public List<Tratamiento> listarTratamientos() {
        return tratamientoRepository.findAll();
    }

    public Tratamiento registrarTratamiento(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }
}
