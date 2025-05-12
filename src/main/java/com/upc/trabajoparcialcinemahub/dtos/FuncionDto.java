package com.upc.trabajoparcialcinemahub.dtos;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionDto implements Serializable {
    Long id;
    LocalDate fecha_funcion;
    LocalTime hora_salida;
    SalaDto sala;
    PeliculaDto pelicula;
}