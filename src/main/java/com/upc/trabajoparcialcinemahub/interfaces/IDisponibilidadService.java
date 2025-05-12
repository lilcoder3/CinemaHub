package com.upc.trabajoparcialcinemahub.interfaces;

import com.upc.trabajoparcialcinemahub.dtos.DisponibilidadDto;
import java.util.List;

public interface IDisponibilidadService {
    List<DisponibilidadDto> buscarDisponibilidadPorCine(Long cineId);
    List<DisponibilidadDto> buscarDisponibilidadPorPelicula(Long peliculaId);
}