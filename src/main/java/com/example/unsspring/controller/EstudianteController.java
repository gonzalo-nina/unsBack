package com.example.unsspring.controller;

import com.example.unsspring.model.Estudiante;
import com.example.unsspring.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;



@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    
    @Autowired
    private EstudianteService estudianteService;

    //Obtener la lista de todos los estudiantes
    @GetMapping
    public List <Estudiante> getEstudiantes(){
        return estudianteService.getEstudiantes();
    }

    //obtener la lista de un estudiantes por su id
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Integer id){
        Estudiante estudiante = estudianteService.getEstudianteById(id);
        if (estudiante != null){
            return ResponseEntity.ok(estudiante);
        }
        return ResponseEntity.notFound().build();
    }

    //Crear estudiante
    @PostMapping
    public Estudiante createEstudiante (@RequestBody Estudiante estudiante){
        return estudianteService.createEstudiante(estudiante);
    }

    //Actualizar estudiante
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Integer id, @RequestBody Estudiante estudiante){
        Estudiante estudianteActual = estudianteService.updateEstudiante(id, estudiante);
        if (estudianteActual != null){
            return ResponseEntity.ok(estudianteActual);
        }
        return ResponseEntity.notFound().build();
    }

    //eliminar estudiante
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Integer id){
        estudianteService.deleteEstudiante(id);
        return ResponseEntity.ok().build();
    }

    



}
