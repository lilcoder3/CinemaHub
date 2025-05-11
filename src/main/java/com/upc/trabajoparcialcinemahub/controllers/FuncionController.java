package com.upc.trabajoparcialcinemahub.controllers;

import com.upc.trabajoparcialcinemahub.dtos.FuncionDto;
import com.upc.trabajoparcialcinemahub.entities.Pelicula;
import com.upc.trabajoparcialcinemahub.entities.Sala;
import com.upc.trabajoparcialcinemahub.services.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FuncionController {
    @Autowired
    private FuncionService funcionService;

    @PostMapping("/funcion")
    public ResponseEntity<FuncionDto> grabarFuncion(@RequestBody FuncionDto funcionDto){
        return ResponseEntity.ok(funcionService.grabarFuncion(funcionDto));
    }

}
