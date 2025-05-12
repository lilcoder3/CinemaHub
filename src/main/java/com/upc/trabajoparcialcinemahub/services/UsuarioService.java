package com.upc.trabajoparcialcinemahub.services;

import com.upc.trabajoparcialcinemahub.dtos.UsuarioDto;
import com.upc.trabajoparcialcinemahub.entities.Usuario;
import com.upc.trabajoparcialcinemahub.interfaces.IUsuarioService;
import com.upc.trabajoparcialcinemahub.repositories.UsuarioRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> listarUsuarios(){
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario grabarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario editarUsuario(Usuario usuario) {
        if (usuarioRepositorio.findById(usuario.getId()).isPresent()) {
            return usuarioRepositorio.save(usuario);
        }
        return null;
    }

    @Override
    public void eliminarUsuario(long id) {
        if(usuarioRepositorio.findById(id).isPresent()){
            usuarioRepositorio.deleteById(id);
        }
    }
}
