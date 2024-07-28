package com.me.CRUD_BIBLIOTECA.controller;

import com.me.CRUD_BIBLIOTECA.model.Persona;
import com.me.CRUD_BIBLIOTECA.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class PersonaController {

    @Autowired
    private PersonaService personaServiceImp;

    @GetMapping("/listar")
    public String getAll(Model model) {
        List<Persona> personas = personaServiceImp.getAll();
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/nuevo")
    public String agregar(Model model) {
        model.addAttribute("persona", new Persona());
        return "form";
    }

    @PostMapping("/save")
    public String save(Persona p, Model model) {
        personaServiceImp.save(p);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Persona> persona = personaServiceImp.getById(id);
        model.addAttribute("persona", persona);
        return "form";
    }

    @PostMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id, Model model) {
        personaServiceImp.delete(id);
        return "redirect:/listar";
    }
}

