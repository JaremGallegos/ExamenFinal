package com.cibertec.examenfinal.jaremgallegos.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cibertec.examenfinal.jaremgallegos.modelo.HistorialOdontologico;

@Repository
public interface HistorialOdontologicoRepository extends JpaRepository<HistorialOdontologico, Long> {
    List<HistorialOdontologico> findByPacienteId(Long pacienteId);
}
