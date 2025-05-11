package com.upc.trabajoparcialcinemahub.interfaces;

import com.upc.trabajoparcialcinemahub.entities.Cine;

import java.util.List;

public interface ICineService {
    public List<Cine> listarCines();
    public Cine grabarCine(Cine cine);
    //public Cine editarCine(Cine cine);
    public void eliminarCine(long id);
}
