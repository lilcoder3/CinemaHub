package com.upc.trabajoparcialcinemahub.dtos;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaDto implements Serializable {
    Long id;
    String titulo;
    String genero;
    LocalDate fecha_estreno;
    String idioma;
    List<CineDto> cines;
}