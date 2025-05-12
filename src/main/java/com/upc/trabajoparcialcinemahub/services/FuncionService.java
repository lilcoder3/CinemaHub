package com.upc.trabajoparcialcinemahub.services;

import com.upc.trabajoparcialcinemahub.dtos.FuncionDto;
import com.upc.trabajoparcialcinemahub.entities.Funcion;
import com.upc.trabajoparcialcinemahub.entities.Pelicula;
import com.upc.trabajoparcialcinemahub.entities.Sala;
import com.upc.trabajoparcialcinemahub.interfaces.IFuncionService;
import com.upc.trabajoparcialcinemahub.repositories.FuncionRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionService implements IFuncionService {
    @Autowired
    private FuncionRepositorio funcionRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    public FuncionDto grabarFuncion(FuncionDto funcionDto){
        Funcion funcion = modelMapper.map(funcionDto, Funcion.class);
        Funcion guardar = funcionRepositorio.save(funcion);
        return modelMapper.map(guardar, FuncionDto.class);
    }

}
