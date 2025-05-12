package com.upc.trabajoparcialcinemahub.controllers;


import com.upc.trabajoparcialcinemahub.dtos.SalaDto;
import com.upc.trabajoparcialcinemahub.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SalaController {
    @Autowired
    private SalaService salaService;

    @PostMapping("/sala")
    public ResponseEntity<SalaDto> grabarSala(@RequestBody SalaDto salaDto){
        return ResponseEntity.ok(salaService.grabarSala(salaDto));
    }
}
