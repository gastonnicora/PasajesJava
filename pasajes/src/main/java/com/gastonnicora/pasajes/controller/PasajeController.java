package com.gastonnicora.pasajes.controller;


import com.gastonnicora.pasajes.model.PasajeModel;
import com.gastonnicora.pasajes.repository.PasajeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pasajes")
public class PasajeController {

    @Autowired
    private PasajeRepository pasajeRepository;

    //@RequestMapping(value = {"/", "/home", "/inicio"}, method = RequestMethod.GET)
    
    // Mostrar todos los pasajes
    @GetMapping({"/",""})
    @ResponseBody
    public List<PasajeModel> verPasajes(Model model) {
    	return pasajeRepository.findAll();
        // model.addAttribute("pasajes", pasajeRepository.findAll());
        // return "pasajes/lista"; // vista con lista de pasajes
    }

    // Mostrar formulario para agregar un pasaje
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pasaje", new PasajeModel());
        return "pasajes/formulario"; // Vista para agregar un nuevo pasaje
    }

    // Guardar un nuevo pasaje
    @PostMapping("/guardar")
    public String guardarPasaje(PasajeModel pasaje) {
        pasajeRepository.save(pasaje);
        return "redirect:/pasajes/"; // Redirige a la lista de pasajes
    }

    // Mostrar detalle de un pasaje específico
    @GetMapping("/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        PasajeModel pasaje = pasajeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pasaje no encontrado"));
        model.addAttribute("pasaje", pasaje);
        return "pasajes/detalle"; // Vista de detalle del pasaje
    }
}
