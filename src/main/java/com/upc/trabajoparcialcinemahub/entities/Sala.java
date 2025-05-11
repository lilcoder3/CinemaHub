package com.upc.trabajoparcialcinemahub.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero_sala;
    private String tipo;
    private int capacidad;
    @ManyToOne
    @JoinColumn(name = "id_cine")
    private Cine cine;
}
