package fr.da2i.jpo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.core.joran.conditional.ElseAction;
import fr.da2i.jpo.entities.Lycee;
import fr.da2i.jpo.entities.Visiteur;
import fr.da2i.jpo.repositories.LyceeRepository;
import fr.da2i.jpo.repositories.VisiteurRepository;

@Controller
public class SaisieController {

	@Autowired
	LyceeRepository lyceeRepo;
	@Autowired
	VisiteurRepository visiteurRepository;

    @Autowired 
	HttpServletRequest request ;

    @GetMapping("/saisie")
	public String getSaisieForm(Model model) {
		model.addAttribute("lycees",lyceeRepo.findAllByOrderByCommune());
		return "saisieform";
	}
	
	@PostMapping("/saisie")
	public Object saveDatas(@RequestParam String prenom, @RequestParam String nom, @RequestParam String email, @RequestParam String dept, @RequestParam int lycee, Model model) {
		Visiteur visiteur = new Visiteur();
		visiteur.setNom(nom);
		visiteur.setPrenom(prenom);
		visiteur.setEmail(email);
		visiteur.setDept(dept);
		visiteur.setLycee(lyceeRepo.findByLno(lycee));
		visiteur.setIp(request.getRemoteAddr());
		// if(visiteurRepository.findByIp(visiteur.getIp()) == null) {
		int vno=0;
		if (visiteurRepository.findByEmailAndDept(email,dept)==null) {
		    vno = visiteurRepository.save(visiteur).getVno();
		    visiteur = visiteurRepository.findById(vno).orElse(null);
		    System.out.println(visiteur.getVno());
			model.addAttribute("numero", vno);
			model.addAttribute("visiteur", visiteur);
	}
		else {
		model.addAttribute("numero", 0);
		}
		return "saisieok";
	}
	
	@GetMapping("/lycee")
	public String getLyceeForm() {
		return "lyceeform";
	}
	
	@PostMapping("/lycee")
	public Object saveLycee(@RequestParam String nom, @RequestParam String codepostal, @RequestParam String commune, Model model) {
		Lycee lycee = new Lycee();
		lycee.setNom(nom);
		lycee.setCodepostal(codepostal);
		lycee.setCommune(commune);
		if (lyceeRepo.findByNomAndCodepostal(nom, codepostal)==null)
			// idealement envoyer un message s'il existe déjà
			lyceeRepo.save(lycee);
		return "redirect:/saisie";
	}

// REST
	@GetMapping(value="/all", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Visiteur> getAllInJSON() {
		List<Visiteur> l = (List<Visiteur>) visiteurRepository.findAll() ;
		return l;
	}

}
