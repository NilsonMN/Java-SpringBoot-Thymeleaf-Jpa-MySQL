package com.me.CRUD_BIBLIOTECA.interfaces;

import com.me.CRUD_BIBLIOTECA.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersona extends JpaRepository<Persona, Long> {
}
