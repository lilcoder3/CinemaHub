package com.upc.trabajoparcialcinemahub.controllers;

import com.upc.trabajoparcialcinemahub.dtos.DisponibilidadDto;
import com.upc.trabajoparcialcinemahub.services.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DisponibilidadController {

    @Autowired
    private DisponibilidadService disponibilidadService;

    @GetMapping("/disponibilidad/cine/{cineId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<DisponibilidadDto>> buscarDisponibilidadPorCine(
            @PathVariable Long cineId) {
        return ResponseEntity.ok(disponibilidadService.buscarDisponibilidadPorCine(cineId));
    }

    @GetMapping("/disponibilidad/pelicula/{peliculaId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<DisponibilidadDto>> buscarDisponibilidadPorPelicula(
            @PathVariable Long peliculaId) {
        return ResponseEntity.ok(disponibilidadService.buscarDisponibilidadPorPelicula(peliculaId));
    }
}