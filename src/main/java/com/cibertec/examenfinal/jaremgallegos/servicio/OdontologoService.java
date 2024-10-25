package com.cibertec.examenfinal.jaremgallegos.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.examenfinal.jaremgallegos.modelo.Odontologo;
import com.cibertec.examenfinal.jaremgallegos.repositorio.OdontologoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;

    public List<Odontologo> listarOdontologos() {
        return odontologoRepository.findAll();
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public Optional<Odontologo> obtenerOdontologoPorId(Long id) {
        return odontologoRepository.findById(id);
    }

    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }
}