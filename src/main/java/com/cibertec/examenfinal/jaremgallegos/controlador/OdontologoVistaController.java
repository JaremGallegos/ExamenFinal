package com.cibertec.examenfinal.jaremgallegos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.examenfinal.jaremgallegos.modelo.Odontologo;
import com.cibertec.examenfinal.jaremgallegos.servicio.OdontologoService;

@Controller
@RequestMapping("/odontologos")
public class OdontologoVistaController {
    @Autowired
    private OdontologoService odontologoService;

    @GetMapping
    public String listarOdontologos(Model model) {
        List<Odontologo> odontologos = odontologoService.listarTodos();
        model.addAttribute("odontologos", odontologos);
        return "odontologos/lista"; 
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoOdontologo(Model model) {
        model.addAttribute("odontologo", new Odontologo());
        return "odontologos/formulario"; 
    }

    @PostMapping
    public String guardarOdontologo(@ModelAttribute Odontologo odontologo) {
        odontologoService.guardar(odontologo);
        return "redirect:/odontologos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarOdontologo(@PathVariable Long id, Model model) {
        Odontologo odontologo = odontologoService.obtenerPorId(id).orElseThrow(() -> new IllegalArgumentException("Odontologo no encontrado: " + id));
        model.addAttribute("odontologo", odontologo);
        return "odontologos/formulario";
    }

    @PostMapping("/editar/{id}")
    public String actualizarOdontologo(@PathVariable Long id, @ModelAttribute Odontologo odontologo) {
        odontologo.setId(id);
        odontologoService.guardar(odontologo);
        return "redirect:/odontologos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarOdontologo(@PathVariable Long id) {
        odontologoService.eliminar(id);
        return "redirect:/odontologos";
    }
}
