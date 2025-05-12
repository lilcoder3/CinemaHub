package com.upc.trabajoparcialcinemahub.services;

import com.upc.trabajoparcialcinemahub.dtos.SalaDto;
import com.upc.trabajoparcialcinemahub.entities.Sala;
import com.upc.trabajoparcialcinemahub.interfaces.ISalaService;
import com.upc.trabajoparcialcinemahub.repositories.SalaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService implements ISalaService {
    @Autowired
    private SalaRepositorio salaRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    public SalaDto grabarSala(SalaDto salaDto){
        Sala sala = modelMapper.map(salaDto, Sala.class);
        Sala guardar = salaRepositorio.save(sala);
        return modelMapper.map(guardar, SalaDto.class);
    }
}
