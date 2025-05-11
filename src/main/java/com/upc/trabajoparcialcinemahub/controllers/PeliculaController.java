package com.upc.trabajoparcialcinemahub.controllers;

import com.upc.trabajoparcialcinemahub.dtos.PeliculaDto;
import com.upc.trabajoparcialcinemahub.entities.Pelicula;
import com.upc.trabajoparcialcinemahub.services.PeliculaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/peliculas")
    @PreAuthorize("hasRole('ADMIN')")
    public List<PeliculaDto> listarPeliculas(){
        List<Pelicula> peliculas = peliculaService.listarPeliculas();
        ModelMapper modelMapper = new ModelMapper();
        return peliculas.stream()
                .map(pelicula -> modelMapper.map(pelicula, PeliculaDto.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @PostMapping("/pelicula")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PeliculaDto> grabarPelicula(@RequestBody PeliculaDto peliculaDto){
        ModelMapper modelMapper = new ModelMapper();
        Pelicula pelicula = modelMapper.map(peliculaDto, Pelicula.class);
        pelicula = peliculaService.grabarPelicula(pelicula);
        peliculaDto = modelMapper.map(pelicula, PeliculaDto.class);
        return ResponseEntity.ok(peliculaDto);
    }

    @DeleteMapping("/pelicula/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarPelicula(@PathVariable long id){
        peliculaService.eliminarPelicula(id);
    }

    @GetMapping("/peliculaxtitulo")
    public ResponseEntity<List<PeliculaDto>> obtenerPeliculasXTitulo(String titulo){
        return ResponseEntity.ok(peliculaService.obtenerPeliculasXTitulo(titulo));
    }

}
