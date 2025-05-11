package com.upc.trabajoparcialcinemahub.services;

import com.upc.trabajoparcialcinemahub.entities.Cine;
import com.upc.trabajoparcialcinemahub.interfaces.ICineService;
import com.upc.trabajoparcialcinemahub.repositories.CineRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CineService implements ICineService {
    @Autowired
    private CineRepositorio cineRepositorio;
    //@Autowired
    //private ModelMapper modelMapper;
    @Transactional
    @Override
    public Cine grabarCine(Cine cine){
        return cineRepositorio.save(cine);
    }

    //@Transactional
    //@Override
    //public Cine editarCine(Cine cine){
    //    return cineRepositorio.save(cine);
    //}

    @Override
    public List<Cine> listarCines(){
        return cineRepositorio.findAll();
    }

    @Transactional
    @Override
    public void eliminarCine(long id){
        if(cineRepositorio.findById(id).isPresent()){
            cineRepositorio.deleteById(id);
        }
    }


    // @Override
    //public CineDto grabarCine(CineDto cineDto) {
    //    Cine cine = modelMapper.map(cineDto, Cine.class);
    //    Cine guardar = cineRepositorio.save(cine);
    //    return modelMapper.map(guardar, CineDto.class);
    //}
}
