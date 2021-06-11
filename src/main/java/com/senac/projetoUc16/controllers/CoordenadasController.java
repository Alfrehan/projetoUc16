package com.senac.projetoUc16.controllers;

import com.senac.projetoUc16.models.Coordenadas;
import com.senac.projetoUc16.repositorys.CoordenadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/coordenadas")
public class CoordenadasController {
    @Autowired
    CoordenadasRepository coordenadasRepository;

    @GetMapping("/")
    public ModelAndView listarCoordenadas(){
        ModelAndView mv = new ModelAndView("coordenadas");
        ArrayList<Coordenadas> coordenadas = new ArrayList<>();
        coordenadas = (ArrayList<Coordenadas>) coordenadasRepository.findAll();
        mv.addObject("coordenadas",coordenadas);
        return mv;
    }

    @GetMapping("/add")
    public String addPage (Model model){
        model.addAttribute("coordenadasForm",new Coordenadas());
        return "coordenadas_add";
    }

    @PostMapping("/add")
    public String addCoordenadas(@ModelAttribute("coordenadasForm") Coordenadas coordenadas){
        coordenadasRepository.save(coordenadas);
        return "redirect:/coordenadas/";
    }

    @PostMapping("/")
    public String addCoordenadas(){
        return "Coordenadas adicionada";
    }
}
