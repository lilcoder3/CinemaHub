package com.upc.trabajoparcialcinemahub.dtos;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaDto implements Serializable {
    Long id;
    Double precio;
    int num_asiento;
    FuncionDto funcion;
}