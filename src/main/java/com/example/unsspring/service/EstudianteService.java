package com.example.unsspring.service;

import com.example.unsspring.model.Estudiante;
import com.example.unsspring.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    
    @Autowired
    private EstudianteRepository estudianteRepository;
    
    //Metodo para listar todos los estudiantes
    public List<Estudiante> getEstudiantes(){
        return estudianteRepository.findAll();
    }

    //Metodo para obtener a un estudiante por su id
    public Estudiante getEstudianteById(Integer id){
        return estudianteRepository.findById(id).orElse(null);
    }

    //Metodo para registrar a un nuevo estudiante
    public Estudiante createEstudiante (Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    //Metodo para editar un estudiante teniendo su id
    public Estudiante updateEstudiante(Integer id, Estudiante estudiante){
        //identificamos a la entidad estudiante sabiendo su id
        Estudiante estudianteActual = estudianteRepository.findById(id).orElse(null);
        if (estudianteActual!=null){
            estudianteActual.setNombre(estudiante.getNombre());
            estudianteActual.setApellido(estudiante.getApellido());
            estudianteActual.setEmail(estudiante.getEmail());
            return estudianteRepository.save(estudianteActual);
        }
        return null;
    }

    //Metodo para eliminar a un estudiante sabiendo su id
    public void deleteEstudiante(Integer id){
        estudianteRepository.deleteById(id);
    }


}
