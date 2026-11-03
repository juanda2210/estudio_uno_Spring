package com.campuslands.practica_uno.persistence.repository;

import com.campuslands.practica_uno.bussines.model.Estudiante;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//Esta anotacion sirve para marcar una interfaz como parte de la capa de persistencia
@Repository
public class RepositoryEstudiantesEnMemoria implements RepositoryEstudiantes{

    List<Estudiante> estudiantes = new ArrayList<>();
    private Long siguienteId = 1L;


    @Override
    public Estudiante guardar(Estudiante estudiante) {
        estudiante.setId(siguienteId++);
        estudiantes.add(estudiante);
        return estudiante;
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        return new ArrayList<>(estudiantes);
    }

    @Override
    public Optional<Estudiante> obtenerPorId(Long id) {
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getId().equals(id))
                .findFirst();
    }

    @Override
    public Boolean existePorCorreo(String correo) {
        return null;
    }
}
