package com.cibertec.examenfinal.jaremgallegos.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.examenfinal.jaremgallegos.modelo.Odontologo;
import com.cibertec.examenfinal.jaremgallegos.servicio.OdontologoService;

@RestController
@RequestMapping("/api/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping
    public List<Odontologo> listarOdontologos() {
        return odontologoService.listarOdontologos();
    }

    @PostMapping
    public ResponseEntity<String> registrarOdontologo(@ModelAttribute Odontologo odontologo) {
        Odontologo nuevoOdontologo = odontologoService.registrarOdontologo(odontologo);
        return ResponseEntity.ok("Odontólogo registrado con éxito: " + nuevoOdontologo.getNombre());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> obtenerOdontologoPorId(@PathVariable Long id) {
        Optional<Odontologo> odontologoOpt = odontologoService.obtenerOdontologoPorId(id);
        return odontologoOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOdontologo(@PathVariable Long id) {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.noContent().build();
    }
}