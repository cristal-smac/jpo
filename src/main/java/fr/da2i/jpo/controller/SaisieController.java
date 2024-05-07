package fr.da2i.jpo.controller;

import java.util.List;

import fr.da2i.jpo.dto.SaisieInput;
import fr.da2i.jpo.repositories.DepartementRepository;
import fr.da2i.jpo.services.LyceeService;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	private final LyceeService lyceeService;
	private final HttpSession session;

	public SaisieController(LyceeRepository lyceeRepo, DepartementRepository deptRepo, VisiteurRepository visiteurRepository, HttpServletRequest request, LyceeService lyceeService, HttpSession session) {
		this.lyceeRepo = lyceeRepo;
		this.deptRepo = deptRepo;
		this.visiteurRepository = visiteurRepository;
		this.request = request;
        this.lyceeService = lyceeService;
        this.session = session;
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
	public Object saveLycee(Lycee input, Model model, @RequestParam(required = false) String force) {
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
		saisie.setLycee(lycee.getLno());
		session.setAttribute("saisie", saisie);
	}

	// REST
	@GetMapping(value="/all", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Visiteur> getAllInJSON() {
		return (List<Visiteur>) visiteurRepository.findAll();
	}

}
