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

import tn.cni.annuaire.entities.Delegation;
import tn.cni.annuaire.responses.MessageResponse;
import tn.cni.annuaire.services.DelegationService;

@RestController
@RequestMapping("/delegation")
@CrossOrigin("*")
public class DelegationController {
	
	@Autowired
	private DelegationService delegationService;
	
	@PostMapping()
	public MessageResponse save(@RequestBody Delegation delegation) {
		return delegationService.save(delegation);
	}
	@PutMapping()
	public MessageResponse update(@RequestBody	 Delegation delegation) {
		return delegationService.update(delegation);
	}
	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable Integer id) {
		return delegationService.delete(id);
	}
	
	@GetMapping()
	public List<Delegation> findAll() {
		return delegationService.findAll();
	}
	@GetMapping("/gouvernorat/{id}")
	public List<Delegation> findByGouvernorat(@PathVariable Integer id) {
		return delegationService.findByGouvernorat(id);
	}


}
