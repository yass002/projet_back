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

import tn.cni.annuaire.entities.Groupe;
import tn.cni.annuaire.responses.MessageResponse;
import tn.cni.annuaire.services.GroupeService;

@RestController
@RequestMapping("/groupe")
@CrossOrigin("*")

public class GroupeController {
	@Autowired
	private GroupeService groupeService;
	
	@PostMapping()
	public MessageResponse save(@RequestBody Groupe groupe) {
		return groupeService.save(groupe);
	}
	@PutMapping()
	public MessageResponse update(@RequestBody	 Groupe groupe) {
		return groupeService.update(groupe);
	}
	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable Integer id) {
		return groupeService.delete(id);
	}
	
	@GetMapping()
	public List<Groupe> findAll() {
		return groupeService.findAll();
	}
}
