package com.upc.trabajoparcialcinemahub.controllers;

import com.upc.trabajoparcialcinemahub.dtos.CineDto;
import com.upc.trabajoparcialcinemahub.entities.Cine;
import com.upc.trabajoparcialcinemahub.interfaces.ICineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
/*
 Exposición controlada: Solo expón las cabeceras estrictamente necesarias,
 como Authorization, para evitar problemas de seguridad.
 Soporte para withCredentials: Si estás trabajando con cookies o tokens,
 asegúrate de incluir allowCredentials(true) tanto en el backend como en
 el cliente (withCredentials: true).
  Pruebas locales y en producción: Verifica que las cabeceras estén
  disponibles en todos los navegadores que vayas a soportar, ya que
  algunos pueden manejar CORS de manera diferente.
 */
@RestController
@CrossOrigin(origins = "${ip.frontend}", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RequestMapping("/api")
public class CineController {
    @Autowired
    private ICineService cineService;

    @GetMapping("/cines")
    @PreAuthorize("hasRole('ADMIN')")
    public List<CineDto> listarCines(){
        List<Cine> cines = cineService.listarCines();
        ModelMapper modelMapper = new ModelMapper();
        return cines.stream()
                .map(cine -> modelMapper.map(cine, CineDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/cine")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CineDto> grabarCine(@RequestBody CineDto cineDto){
        ModelMapper modelMapper = new ModelMapper();
        Cine cine = modelMapper.map(cineDto, Cine.class);
        cine = cineService.grabarCine(cine);
        cineDto = modelMapper.map(cine, CineDto.class);
        return ResponseEntity.ok(cineDto);
    }

    @GetMapping("/cines/distrito/{distrito}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<CineDto> buscarCinesPorDistrito(@PathVariable String distrito) {
        List<Cine> cines = cineService.buscarCinesPorDistrito(distrito);
        ModelMapper modelMapper = new ModelMapper();
        return cines.stream()
                .map(cine -> modelMapper.map(cine, CineDto.class))
                .collect(Collectors.toList());
    }

    //@GetMapping("/cines/provincia/{provincia}")
    //@PreAuthorize("hasRole('ADMIN')")
    //public List<CineDto> buscarCinesPorProvincia(@PathVariable String provincia) {
    //    List<Cine> cines = cineService.buscarCinesPorProvincia(provincia);
    //    ModelMapper modelMapper = new ModelMapper();
    //    return cines.stream()
    //            .map(cine -> modelMapper.map(cine, CineDto.class))
    //            .collect(Collectors.toList());
    //}

    //@GetMapping("/cines/region/{region}")
    //@PreAuthorize("hasRole('ADMIN')")
    //public List<CineDto> buscarCinesPorRegion(@PathVariable String region) {
    //    List<Cine> cines = cineService.buscarCinesPorRegion(region);
    //    ModelMapper modelMapper = new ModelMapper();
    //    return cines.stream()
    //            .map(cine -> modelMapper.map(cine, CineDto.class))
    //            .collect(Collectors.toList());
    //}

    @DeleteMapping("/cine/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarCine(@PathVariable long id){
        cineService.eliminarCine(id);
    }

}
