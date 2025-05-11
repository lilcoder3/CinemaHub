package com.upc.trabajoparcialcinemahub.services;

import com.upc.trabajoparcialcinemahub.dtos.DisponibilidadDto;
import com.upc.trabajoparcialcinemahub.entities.Entrada;
import com.upc.trabajoparcialcinemahub.entities.Funcion;
import com.upc.trabajoparcialcinemahub.interfaces.IDisponibilidadService;
import com.upc.trabajoparcialcinemahub.repositories.EntradaRepositorio;
import com.upc.trabajoparcialcinemahub.repositories.FuncionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisponibilidadService implements IDisponibilidadService {
    @Autowired
    private FuncionRepositorio funcionRepositorio;
    
    @Autowired
    private EntradaRepositorio entradaRepositorio;  // Nueva dependencia

    @Override
    public List<DisponibilidadDto> buscarDisponibilidadPorCine(Long cineId) {
        List<Funcion> funciones = funcionRepositorio.findByCineId(cineId);
        return mapearFuncionesADisponibilidad(funciones);
    }

    @Override
    public List<DisponibilidadDto> buscarDisponibilidadPorPelicula(Long peliculaId) {
        List<Funcion> funciones = funcionRepositorio.findByPeliculaId(peliculaId);
        return mapearFuncionesADisponibilidad(funciones);
    }

    private List<DisponibilidadDto> mapearFuncionesADisponibilidad(List<Funcion> funciones) {
        return funciones.stream()
                .map(this::crearDisponibilidadDto)
                .collect(Collectors.toList());
    }

    private DisponibilidadDto crearDisponibilidadDto(Funcion funcion) {
        return new DisponibilidadDto(
                funcion.getSala().getCine().getNombre(),
                funcion.getPelicula().getTitulo(),
                formatearNumeroSala(funcion.getSala().getNumero_sala()),
                funcion.getHora_salida().toString(),
                funcion.getSala().getCapacidad(),
                obtenerPrecioFuncion(funcion)
        );
    }

    private Double obtenerPrecioFuncion(Funcion funcion) {
        return entradaRepositorio.findFirstByFuncionId(funcion.getId())
                .map(Entrada::getPrecio)
                .orElse(0.0);
    }

    private String formatearNumeroSala(int numeroSala) {
        return "Sala " + numeroSala;
    }
}