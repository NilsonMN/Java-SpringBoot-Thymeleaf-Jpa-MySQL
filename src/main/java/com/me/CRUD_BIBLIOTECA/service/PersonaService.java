package com.me.CRUD_BIBLIOTECA.service;

import com.me.CRUD_BIBLIOTECA.exception.NotFoundException;
import com.me.CRUD_BIBLIOTECA.interfaceService.IPersonaService;
import com.me.CRUD_BIBLIOTECA.model.Persona;
import com.me.CRUD_BIBLIOTECA.interfaces.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersona iPersona;

    @Override
    public List<Persona> getAll() {
        return (List<Persona>) iPersona.findAll();
    }

    @Override
    public Optional<Persona> getById(Long id) {
        return iPersona.findById(id);
    }

    @Override
    public int save(Persona persona) {
        int resp = 0;
        Persona persona1 = iPersona.save(persona);
        if (!persona1.equals(null)) {
            resp = 1;
        }
        return resp;
    }

    @Override
    public void delete(Long id) {
        iPersona.deleteById(id);
    }

    @Override
    public Persona update(Persona persona) {
        Optional<Persona> personaActualizar = iPersona.findById(persona.getId());
        if (!personaActualizar.isPresent()) {
            throw new NotFoundException("Error");
        }
        return iPersona.save(persona);
    }
}
