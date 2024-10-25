package com.cibertec.examenfinal.jaremgallegos.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        return odontologoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> obtenerOdontologoPorId(@PathVariable Long id) {
        Optional<Odontologo> odontologo = odontologoService.obtenerPorId(id);
        return odontologo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Odontologo crearOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.guardar(odontologo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Odontologo> actualizarOdontologo(@PathVariable Long id, @RequestBody Odontologo detallesOdontologo) {
        Optional<Odontologo> odontologo = odontologoService.obtenerPorId(id);

        if (odontologo.isPresent()) {
            Odontologo odontologoActualizado = odontologo.get();
            odontologoActualizado.setNombre(detallesOdontologo.getNombre());
            odontologoActualizado.setEspecialidad(detallesOdontologo.getEspecialidad());
            odontologoActualizado.setTelefono(detallesOdontologo.getTelefono());
            odontologoActualizado.setCorreo(detallesOdontologo.getCorreo());
            odontologoActualizado.setDireccion(detallesOdontologo.getDireccion());

            return ResponseEntity.ok(odontologoService.guardar(odontologoActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOdontologo(@PathVariable Long id) {
        if (odontologoService.obtenerPorId(id).isPresent()) {
            odontologoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
