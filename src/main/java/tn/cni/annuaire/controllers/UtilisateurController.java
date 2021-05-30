package tn.cni.annuaire.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.cni.annuaire.entities.Utilisateur;
import tn.cni.annuaire.responses.MessageResponse;
import tn.cni.annuaire.services.UtilisateurService;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilisateurService;
	@PostMapping
	private MessageResponse save(@RequestBody Utilisateur utilisateur) {
			return utilisateurService.save(utilisateur);
	}
	@PutMapping
	private MessageResponse update(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.update(utilisateur);
}
	@DeleteMapping("/{id}")
	private MessageResponse delete(@PathVariable Integer id) {
		return utilisateurService.delete(id);
}
	@GetMapping
	private List<Utilisateur> findAll( ) {
		return utilisateurService.findAll();
	}
	@GetMapping("/{id}")
	private Utilisateur getbyId(@PathVariable Integer id) {
		return utilisateurService.getById(id);
		}
	
}	
