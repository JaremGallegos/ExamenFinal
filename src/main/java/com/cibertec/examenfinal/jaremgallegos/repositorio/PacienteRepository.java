package com.cibertec.examenfinal.jaremgallegos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cibertec.examenfinal.jaremgallegos.modelo.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
