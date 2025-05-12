package com.upc.trabajoparcialcinemahub.controllers;


import com.upc.trabajoparcialcinemahub.dtos.UsuarioDto;
import com.upc.trabajoparcialcinemahub.entities.Usuario;
import com.upc.trabajoparcialcinemahub.interfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuarios")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UsuarioDto> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        ModelMapper modelMapper = new ModelMapper();
        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDto.class))
                .collect(java.util.stream.Collectors.toList());
    }


    @PostMapping("/usuario")
    public ResponseEntity<UsuarioDto> grabarUsuario(@RequestBody UsuarioDto usuarioDto){
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        usuario = usuarioService.grabarUsuario(usuario);
        usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
        return ResponseEntity.ok(usuarioDto);
    }

    @PutMapping("/usuario")
    public ResponseEntity<UsuarioDto>  editarCliente(@RequestBody UsuarioDto usuarioDto) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        usuario = usuarioService.editarUsuario(usuario);
        usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
        return ResponseEntity.ok(usuarioDto);
    }
    @DeleteMapping("/usuario/{id}")
    public void eliminarCliente(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
    }
}
