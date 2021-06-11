package com.senac.projetoUc16.controllersRest;

import com.senac.projetoUc16.models.Coordenadas;
import com.senac.projetoUc16.repositorys.CoordenadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/coordenadas")
public class CoordenadasControllerRest {

    @Autowired
    CoordenadasRepository coordenadasRepository;

    @GetMapping("/listar")
    public ArrayList<Coordenadas> listar(){
        ArrayList<Coordenadas> coordenadas = new ArrayList<>();
        coordenadas = (ArrayList<Coordenadas>) coordenadasRepository.findAll();
        return coordenadas;
    }

    @PostMapping("/addRest")
    public String addUsuario(){
        Coordenadas coordenadas = new Coordenadas();
        coordenadas.setLatitude("");
        coordenadas.setLongitude("");
        coordenadasRepository.save(coordenadas);
        return "Coordenadas adicionada";
    }

    @PutMapping("/editar")
    public String editarCoordenadas(){
        return "coordenadas editada";
    }
}