package com.upc.trabajoparcialcinemahub.dtos;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CineDto implements Serializable {
    Long id;
    String nombre;
    String direccion;
    String distrito;
    String provincia;
    String region;
    String telefono;
    UsuarioDto usuario;
}