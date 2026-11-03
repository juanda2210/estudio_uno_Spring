package com.campuslands.practica_uno.persistence.repository;

import com.campuslands.practica_uno.bussines.model.Estudiante;

import java.util.List;
import java.util.Optional;

public interface RepositoryEstudiantes {

    Estudiante guardar(Estudiante estudiante);

    List<Estudiante> obtenerTodos();

    Optional<Estudiante> obtenerPorId(Long id);

    Boolean existePorCorreo(String correo);
}
