package com.upc.trabajoparcialcinemahub.services;

import com.upc.trabajoparcialcinemahub.dtos.EntradaDetalleDto;
import com.upc.trabajoparcialcinemahub.dtos.EntradaDto;
import com.upc.trabajoparcialcinemahub.entities.Entrada;
import com.upc.trabajoparcialcinemahub.entities.Usuario;
import com.upc.trabajoparcialcinemahub.interfaces.IEntradaService;
import com.upc.trabajoparcialcinemahub.repositories.EntradaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService implements IEntradaService {
    @Autowired
    private EntradaRepositorio entradaRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Entrada> listarEntradas(){
        return entradaRepositorio.findAll();
    }

    @Override
    public EntradaDto grabarEntrada(EntradaDto entradaDto){
        Entrada entrada = modelMapper.map(entradaDto, Entrada.class);
        Entrada guardar = entradaRepositorio.save(entrada);
        return modelMapper.map(guardar, EntradaDto.class);
    }

    @Override
    public List<EntradaDetalleDto> listarEntradasOrdenadas() {
        return entradaRepositorio.findAllEntradasOrdenadas();
    }
}