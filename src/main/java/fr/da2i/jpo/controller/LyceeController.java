package fr.da2i.jpo.controller;

import fr.da2i.jpo.dto.SaisieInput;
import fr.da2i.jpo.entities.Lycee;
import fr.da2i.jpo.repositories.LyceeRepository;
import fr.da2i.jpo.services.LyceeService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lycee")
public class LyceeController {
    private final LyceeRepository lyceeRepo;
    private final LyceeService lyceeService;
    private final HttpSession session;

    public LyceeController(LyceeRepository lyceeRepo, LyceeService lyceeService, HttpSession session) {
        this.lyceeRepo = lyceeRepo;
        this.lyceeService = lyceeService;
        this.session = session;
    }

    @GetMapping
    public String getLyceeForm(Model model) {
        model.addAttribute("lycee", new Lycee());
        return "lyceeform";
    }

    @PostMapping
    public Object saveLycee(@Valid Lycee input, Model model, @RequestParam(required = false) String force) {
        Lycee similar = lyceeService.getSimilarHighSchool(input);
        boolean nameAlreadyExists = similar != null && input.getNom().equals(similar.getNom());
        // Si aucun nom est similaire, ou qu'on force l'ajout d'un lycée similaire
        if (similar == null || (force != null && !nameAlreadyExists)) {
            lyceeRepo.save(input);
            changeSaisieLycee(input);
            return "redirect:/saisie";
        }
        changeSaisieLycee(similar);
        // Si le nom est similaire mais pas égal, on propose d'ajouter
        if (!nameAlreadyExists) {
            model.addAttribute("input", input);
            model.addAttribute("similar", similar);
            return "lyceeconfirm";
        }
        // Sinon on redirige sans rien ajouter ou proposer
        return "redirect:/saisie";
    }

    private void changeSaisieLycee(Lycee lycee) {
        SaisieInput saisie = (SaisieInput) session.getAttribute("saisie");
        if (saisie == null) {
            saisie = new SaisieInput();
        }
        saisie.setLycee(lycee.getLno());
        session.setAttribute("saisie", saisie);
    }
}
