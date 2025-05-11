package com.upc.trabajoparcialcinemahub.dtos;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaDto implements Serializable {
    Long id;
    int numero_sala;
    String tipo;
    int capacidad;
    CineDto cine;
}