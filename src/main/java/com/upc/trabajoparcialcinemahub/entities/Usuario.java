package com.upc.trabajoparcialcinemahub.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String ciudad;
    //private String rol;
    private String telefono;
}