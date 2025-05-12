package com.upc.trabajoparcialcinemahub.repositories;

import com.upc.trabajoparcialcinemahub.entities.Cine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CineRepositorio extends JpaRepository<Cine, Long> {
    List<Cine> findByDistrito(String distrito);
    //List<Cine> findByProvincia(String provincia);
    //List<Cine> findByRegion(String region);
}
