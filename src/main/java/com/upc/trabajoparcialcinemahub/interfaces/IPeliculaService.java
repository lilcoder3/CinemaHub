package com.upc.trabajoparcialcinemahub.interfaces;

import com.upc.trabajoparcialcinemahub.dtos.PeliculaDto;
import com.upc.trabajoparcialcinemahub.entities.Pelicula;

import java.util.List;

public interface IPeliculaService {
    public List<Pelicula> listarPeliculas();
    public Pelicula grabarPelicula(Pelicula pelicula);
    public void eliminarPelicula(long id);
    public List<PeliculaDto> obtenerPeliculasXTitulo(String titulo);
}
