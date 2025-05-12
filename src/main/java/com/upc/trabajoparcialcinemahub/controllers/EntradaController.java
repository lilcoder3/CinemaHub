package com.upc.trabajoparcialcinemahub.controllers;

import com.upc.trabajoparcialcinemahub.dtos.EntradaDetalleDto;
import com.upc.trabajoparcialcinemahub.dtos.EntradaDto;
import com.upc.trabajoparcialcinemahub.dtos.UsuarioDto;
import com.upc.trabajoparcialcinemahub.entities.Entrada;
import com.upc.trabajoparcialcinemahub.entities.Usuario;
import com.upc.trabajoparcialcinemahub.services.EntradaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EntradaController {
    @Autowired
    private EntradaService entradaService;

    @GetMapping("/entradas")
    public List<EntradaDto> listarEntradas(){
        List<Entrada> entradas = entradaService.listarEntradas();
        ModelMapper modelMapper = new ModelMapper();
        return entradas.stream()
                .map(entrada -> modelMapper.map(entrada, EntradaDto.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @GetMapping("/entradas/ordenadas")
    public ResponseEntity<List<EntradaDetalleDto>> listarEntradasOrdenadas() {
        return ResponseEntity.ok(entradaService.listarEntradasOrdenadas());
    }

    @PostMapping("/entrada")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EntradaDto> grabarEntrada(@RequestBody EntradaDto entradaDto){
        return ResponseEntity.ok(entradaService.grabarEntrada(entradaDto));
    }


}
