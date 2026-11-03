package com.campuslands.practica_uno.bussines.service;

import com.campuslands.practica_uno.bussines.model.Estudiante;
import com.campuslands.practica_uno.persistence.repository.RepositoryEstudiantes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


// Esta clase se marca como un proveedor de servicios que contiene la logica de negocio de la aplicacion
//Por ser parte de la logica del negocio, entonces es donde se validan datos, calculan precios, etc...
@Service
public class ServiceEstudiantes {

    private final RepositoryEstudiantes repositoryEstudiantes;

    public ServiceEstudiantes(RepositoryEstudiantes repositoryEstudiantes) {
        this.repositoryEstudiantes = repositoryEstudiantes;
    }

    public Estudiante registrar(Estudiante estudiante) {
        if (repositoryEstudiantes.existePorCorreo(estudiante.getCorreo())) {
            throw new IllegalArgumentException("Ya existe un estudiante con el correo " + estudiante.getCorreo());
        }

        return repositoryEstudiantes.guardar(estudiante);
    }

    public List<Estudiante> listar() {
        return repositoryEstudiantes.obtenerTodos();
    }

    public Estudiante obtener(Long id) {
        return repositoryEstudiantes.obtenerPorId(id)
                .orElseThrow(() -> new NoSuchElementException("No existe el estudiante " + id));
    }
}
