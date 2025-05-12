package com.upc.trabajoparcialcinemahub.dtos;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto implements Serializable {
    Long id;
    int dni;
    String nombre;
    String apellidos;
    String direccion;
    String ciudad;
    //String rol;
    String telefono;
}