package com.me.CRUD_BIBLIOTECA.interfaceService;

import com.me.CRUD_BIBLIOTECA.model.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public List<Persona> getAll();
    public Optional<Persona> getById(Long id);
    public int save(Persona persona);
    public void delete(Long id);
    public Persona update(Persona persona);
}
