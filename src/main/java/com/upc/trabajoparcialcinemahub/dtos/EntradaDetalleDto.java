package com.upc.trabajoparcialcinemahub.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaDetalleDto {
    private Double precio;
    private String nombreCine;
    private String nombrePelicula;
    private LocalTime horaFuncion;
    private LocalDate fechaFuncion;
}
