package com.upc.trabajoparcialcinemahub.repositories;

import com.upc.trabajoparcialcinemahub.dtos.EntradaDetalleDto;
import com.upc.trabajoparcialcinemahub.entities.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EntradaRepositorio extends JpaRepository<Entrada, Long> {
    @Query("SELECT e FROM Entrada e WHERE e.funcion.id = :funcionId ORDER BY e.id ASC LIMIT 1")
    Optional<Entrada> findFirstByFuncionId(@Param("funcionId") Long funcionId);

    @Query("SELECT NEW com.upc.trabajoparcialcinemahub.dtos.EntradaDetalleDto(" +
            "e.precio, " +
            "e.funcion.sala.cine.nombre, " +
            "e.funcion.pelicula.titulo, " +
            "e.funcion.hora_salida, " +
            "e.funcion.fecha_funcion) " +
            "FROM Entrada e " +
            "ORDER BY e.precio ASC")
    List<EntradaDetalleDto> findAllEntradasOrdenadas();
}
