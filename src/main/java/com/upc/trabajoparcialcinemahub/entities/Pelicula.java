package com.upc.trabajoparcialcinemahub.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String genero;
    private LocalDate fecha_estreno;
    private String idioma;

    @ManyToMany
    @JoinTable(
            name = "pelicula_cine",
            joinColumns = @JoinColumn(name = "pelicula_id", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "cine_id")
    )
    private List<Cine> cines;
}
