package com.upc.trabajoparcialcinemahub.repositories;

import com.upc.trabajoparcialcinemahub.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
