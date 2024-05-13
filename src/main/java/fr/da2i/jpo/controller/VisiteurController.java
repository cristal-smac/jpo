package fr.da2i.jpo.controller;

import fr.da2i.jpo.entities.Visiteur;
import fr.da2i.jpo.repositories.VisiteurRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/all")
public class VisiteurController {
    private final VisiteurRepository visiteurRepository;

    public VisiteurController(VisiteurRepository visiteurRepository) {
        this.visiteurRepository = visiteurRepository;
    }

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Visiteur> getAllInJSON() {
        return (List<Visiteur>) visiteurRepository.findAll();
    }
}
