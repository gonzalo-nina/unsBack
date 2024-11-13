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

    

}
