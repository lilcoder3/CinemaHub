package com.upc.trabajoparcialcinemahub.interfaces;

import com.upc.trabajoparcialcinemahub.dtos.EntradaDetalleDto;
import com.upc.trabajoparcialcinemahub.dtos.EntradaDto;
import com.upc.trabajoparcialcinemahub.entities.Entrada;
import com.upc.trabajoparcialcinemahub.entities.Usuario;

import java.util.List;

public interface IEntradaService {
    public EntradaDto grabarEntrada(EntradaDto entradaDto);
    public List<Entrada> listarEntradas();

    List<EntradaDetalleDto> listarEntradasOrdenadas();

}
