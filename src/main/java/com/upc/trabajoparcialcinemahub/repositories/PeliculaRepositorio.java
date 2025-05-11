package com.upc.trabajoparcialcinemahub.repositories;

import com.upc.trabajoparcialcinemahub.dtos.PeliculaDto;
import com.upc.trabajoparcialcinemahub.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaRepositorio extends JpaRepository<Pelicula, Long> {
    List<Pelicula> findPeliculaByTitulo(String titulo);
}
