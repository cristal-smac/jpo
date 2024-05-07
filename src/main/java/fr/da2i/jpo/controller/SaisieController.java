package fr.da2i.jpo.controller;

import java.util.List;

import fr.da2i.jpo.dto.SaisieInput;
import fr.da2i.jpo.repositories.DepartementRepository;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import fr.da2i.jpo.entities.Lycee;
import fr.da2i.jpo.entities.Visiteur;
import fr.da2i.jpo.repositories.LyceeRepository;
import fr.da2i.jpo.repositories.VisiteurRepository;

@Controller
public class SaisieController {
	private final LyceeRepository lyceeRepo;
	private final DepartementRepository deptRepo;
	private final VisiteurRepository visiteurRepository;
    private final HttpServletRequest request ;

	public SaisieController(LyceeRepository lyceeRepo, DepartementRepository deptRepo, VisiteurRepository visiteurRepository, HttpServletRequest request) {
		this.lyceeRepo = lyceeRepo;
		this.deptRepo = deptRepo;
		this.visiteurRepository = visiteurRepository;
		this.request = request;
	}

	@GetMapping("/saisie")
	public String getSaisieForm(Model model) {
		model.addAttribute("departements", deptRepo.findAll());
		model.addAttribute("lycees",lyceeRepo.findAllByOrderByCommune());
		return "saisieform";
	}
	
	@PostMapping("/saisie")
	public Object saveDatas(SaisieInput saisie, Model model) {
		Visiteur visiteur = new Visiteur();
		visiteur.setNom(saisie.getNom());
		visiteur.setPrenom(saisie.getPrenom());
		visiteur.setEmail(saisie.getEmail());
		visiteur.setDept(saisie.getDept());
		visiteur.setLycee(lyceeRepo.findByLno(saisie.getLycee()));
		visiteur.setIp(request.getRemoteAddr());

		if (visiteurRepository.findByEmailAndDept(saisie.getEmail(),saisie.getDept())==null) {
		    int vno = visiteurRepository.save(visiteur).getVno();
		    visiteur = visiteurRepository.findById(vno).orElse(null);
			model.addAttribute("numero", vno);
			model.addAttribute("visiteur", visiteur);
		} else {
			model.addAttribute("numero", 0);
		}
		// Quand la saisie est terminée on retire de la session le formulaire sauvegardé
		model.addAttribute("saisie", null);
		return "saisieok";
	}

	// Garde en mémoire le formulaire de saisie et redirige sur la page pour ajouter un lycée
	@PostMapping("/saveSaisieForm")
	public String getLyceeForm(@ModelAttribute SaisieInput saisie, HttpSession session) {
		session.setAttribute("saisie", saisie);
		return "redirect:/lycee";
	}

	@GetMapping("/lycee")
	public String getLyceeForm(Model model) {
		model.addAttribute("lycee", new Lycee());
		return "lyceeform";
	}
	
	@PostMapping("/lycee")
	public Object saveLycee(@Valid Lycee lycee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "lyceeform";

		if (lyceeRepo.findByNomAndCodepostal(lycee.getNom(), lycee.getCodepostal())==null)
			// idealement envoyer un message s'il existe déjà
			lyceeRepo.save(lycee);
		return "redirect:/saisie";
	}

// REST
	@GetMapping(value="/all", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Visiteur> getAllInJSON() {
		return (List<Visiteur>) visiteurRepository.findAll();
	}

}
