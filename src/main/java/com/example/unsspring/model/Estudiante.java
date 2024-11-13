package com.example.unsspring.model;

import jakarta.persistence.*;

@Entity
@Table(name="estudiante")
public class Estudiante {
    
    //Creación de la clave primaria autoincremental id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Columna Nombre
    @Column(length = 50, nullable = false)
    private String nombre;

    //Columna Apellido
    @Column(length = 50, nullable = false)
    private String apellido;

    //Columna email
    @Column(length = 50, nullable = false)
    private String email;



}
