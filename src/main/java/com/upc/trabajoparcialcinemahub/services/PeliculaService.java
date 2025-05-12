package com.upc.trabajoparcialcinemahub.services;

import com.upc.trabajoparcialcinemahub.dtos.PeliculaDto;
import com.upc.trabajoparcialcinemahub.entities.Pelicula;
import com.upc.trabajoparcialcinemahub.interfaces.IPeliculaService;
import com.upc.trabajoparcialcinemahub.repositories.PeliculaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService implements IPeliculaService {
    @Autowired
    private PeliculaRepositorio peliculaRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Pelicula grabarPelicula(Pelicula pelicula){
        return peliculaRepositorio.save(pelicula);
    }

    @Override
    public List<Pelicula> listarPeliculas(){
        return peliculaRepositorio.findAll();
    }

    @Override
    public void eliminarPelicula(long id){
        peliculaRepositorio.deleteById(id);
    }

    @Override
    public List<PeliculaDto> obtenerPeliculasXTitulo(String titulo){
        return peliculaRepositorio.findPeliculaByTitulo(titulo)
                .stream()
                .map(pelicula -> modelMapper.map(pelicula, PeliculaDto.class))
                .toList();
    }

}
