package com.cibertec.examenfinal.jaremgallegos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<Odontologo> odontologos = odontologoService.listarOdontologos();
        model.addAttribute("odontologos", odontologos);
        model.addAttribute("odontologo", new Odontologo());  
        return "odontologos";  
    }
}