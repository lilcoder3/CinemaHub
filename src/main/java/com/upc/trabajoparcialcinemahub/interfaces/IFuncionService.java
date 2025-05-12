package com.upc.trabajoparcialcinemahub.interfaces;

import com.upc.trabajoparcialcinemahub.dtos.FuncionDto;
import com.upc.trabajoparcialcinemahub.entities.Funcion;
import com.upc.trabajoparcialcinemahub.entities.Pelicula;
import com.upc.trabajoparcialcinemahub.entities.Sala;

public interface IFuncionService {
    public FuncionDto grabarFuncion(FuncionDto funcionDto);
}
