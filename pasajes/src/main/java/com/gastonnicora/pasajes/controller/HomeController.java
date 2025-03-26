package com.gastonnicora.pasajes.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping( {"/",""})
    public String home(Model model) {
        // Agregar un atributo al modelo que Thymeleaf usará en la vista
        model.addAttribute("nombre", "Gaston");  // Puedes cambiar "Gaston" por cualquier valor dinámico
        return "index.html";  // El nombre del archivo de la plantilla, sin la extensión ".html"
    }
    
}
