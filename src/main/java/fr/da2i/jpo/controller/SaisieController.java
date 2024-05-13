package fr.da2i.jpo.controller;

import java.util.Optional;

import fr.da2i.jpo.dto.SaisieInput;
import fr.da2i.jpo.entities.Departement;
import fr.da2i.jpo.repositories.DepartementRepository;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.da2i.jpo.entities.Lycee;
import fr.da2i.jpo.entities.Visiteur;
import fr.da2i.jpo.repositories.LyceeRepository;
import fr.da2i.jpo.repositories.VisiteurRepository;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/saisie")
public class SaisieController {
	private final LyceeRepository lyceeRepo;
	private final DepartementRepository deptRepo;
	private final VisiteurRepository visiteurRepository;
    private final HttpServletRequest request;

	public SaisieController(LyceeRepository lyceeRepo, DepartementRepository deptRepo, VisiteurRepository visiteurRepository, HttpServletRequest request) {
		this.lyceeRepo = lyceeRepo;
		this.deptRepo = deptRepo;
		this.visiteurRepository = visiteurRepository;
		this.request = request;
    }

	@GetMapping
	public String getSaisieForm(Model model) {
		model.addAttribute("departements", deptRepo.findAll());
		model.addAttribute("lycees",lyceeRepo.findAllByOrderByCommune());
		return "saisieform";
	}
	
	@PostMapping
	public Object saveDatas(@Valid SaisieInput saisie, Model model, HttpSession session) {
		Visiteur visiteur = new Visiteur();
		Optional<Departement> dept = deptRepo.findById(saisie.getDept());
		visiteur.setDept(dept.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
		Optional<Lycee> lycee = lyceeRepo.findById(saisie.getLycee());
		visiteur.setLycee(lycee.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
		visiteur.setNom(saisie.getNom());
		visiteur.setPrenom(saisie.getPrenom());
		visiteur.setEmail(saisie.getEmail());
		visiteur.setIp(request.getRemoteAddr());

		if (visiteurRepository.findByEmailAndDept(saisie.getEmail(),dept.get())==null) {
		    int vno = visiteurRepository.save(visiteur).getVno();
		    visiteur = visiteurRepository.findById(vno).orElse(null);
			model.addAttribute("numero", vno);
			model.addAttribute("visiteur", visiteur);
		} else {
			model.addAttribute("numero", 0);
		}
		// Quand la saisie est terminée on retire de la session le formulaire sauvegardé
		session.setAttribute("saisie", null);
		return "saisieok";
	}

	// Garde en mémoire le formulaire de saisie et redirige sur la page pour ajouter un lycée
	@PostMapping("/redirectLycee")
	public String getLyceeForm(@ModelAttribute SaisieInput saisie, HttpSession session) {
		session.setAttribute("saisie", saisie);
		return "redirect:/lycee";
	}
}
