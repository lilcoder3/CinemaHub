package com.upc.trabajoparcialcinemahub.repositories;

import com.upc.trabajoparcialcinemahub.entities.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionRepositorio extends JpaRepository<Funcion, Long> {

    @Query("SELECT f FROM Funcion f WHERE f.sala.cine.id = :cineId")
    List<Funcion> findByCineId(@Param("cineId") Long cineId);

    @Query("SELECT f FROM Funcion f WHERE f.pelicula.id = :peliculaId")
    List<Funcion> findByPeliculaId(@Param("peliculaId") Long peliculaId);



}
