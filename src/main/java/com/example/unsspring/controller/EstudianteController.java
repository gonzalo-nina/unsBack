package com.example.unsspring.controller;

import com.example.unsspring.model.Estudiante;
import com.example.unsspring.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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



}
