package com.campuslands.practica_uno.presentation.controller;


import com.campuslands.practica_uno.bussines.model.Estudiante;
import com.campuslands.practica_uno.bussines.service.ServiceEstudiantes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Esta anotacion nos ayuda a Crear APIs RESTful.
//Nos ayuda a devolver Datos puros (JSON, XML, texto).
@RestController

//Esta anotacion  se utiliza para mapear (conectar) una solicitud web (HTTP)
// a un metodo específico dentro de un controlador.
@RequestMapping("/estudiantes")
public class ControladorEstudiantes {

    private final ServiceEstudiantes serviceEstudiantes;

    public ControladorEstudiantes(ServiceEstudiantes serviceEstudiantes) {
        this.serviceEstudiantes = serviceEstudiantes;
    }

    //Esta anotacion se utiliza para manejar solicitudes HTTP de tipo POST
    // y asociar una URL específica a un metodo en tu controlador
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Estudiante registrar(@RequestBody Estudiante estudiante) {
        return serviceEstudiantes.registrar(estudiante);
    }

    //es una anotación que se utiliza para asociar (mapear) las solicitudes HTTP
    // de tipo GET con un metodo específico dentro de un controlador
    @GetMapping
    public List<Estudiante> listar() {
        return serviceEstudiantes.listar();
    }

    @GetMapping("/{id}")
    public Estudiante obtener(@PathVariable Long id) {
        return serviceEstudiantes.obtener(id);
    }
}
