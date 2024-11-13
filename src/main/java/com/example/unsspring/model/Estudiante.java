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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    



}
