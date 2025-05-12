package com.upc.trabajoparcialcinemahub.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisponibilidadDto {
    private String cineNombre;
    private String peliculaTitulo;
    private String sala;
    private String horario;
    private int asientosDisponibles;
    private Double precio;
}