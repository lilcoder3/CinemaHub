package com.upc.trabajoparcialcinemahub.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String distrito;
    private String provincia;
    private String region;
    private String telefono;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = true)
    private Usuario usuario;

    @ManyToMany(mappedBy = "cines")
    private List<Pelicula> peliculas;
    
}
