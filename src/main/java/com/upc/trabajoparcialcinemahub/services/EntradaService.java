package com.upc.trabajoparcialcinemahub.services;

import com.upc.trabajoparcialcinemahub.dtos.EntradaDto;
import com.upc.trabajoparcialcinemahub.entities.Entrada;
import com.upc.trabajoparcialcinemahub.repositories.EntradaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaService {
    @Autowired
    private EntradaRepositorio entradaRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    public EntradaDto grabarEntrada(EntradaDto entradaDto){
        Entrada entrada = modelMapper.map(entradaDto, Entrada.class);
        Entrada guardar = entradaRepositorio.save(entrada);
        return modelMapper.map(guardar, EntradaDto.class);
    }
}
