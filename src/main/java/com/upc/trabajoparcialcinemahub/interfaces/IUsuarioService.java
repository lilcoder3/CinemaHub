package com.upc.trabajoparcialcinemahub.interfaces;

import com.upc.trabajoparcialcinemahub.dtos.UsuarioDto;
import com.upc.trabajoparcialcinemahub.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listarUsuarios();
    public Usuario grabarUsuario(Usuario usuario);
    public Usuario editarUsuario(Usuario usuario);
    public void eliminarUsuario(long id);
}
