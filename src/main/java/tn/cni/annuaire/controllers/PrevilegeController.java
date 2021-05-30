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

import tn.cni.annuaire.entities.Previlege;
import tn.cni.annuaire.responses.MessageResponse;
import tn.cni.annuaire.services.PrevilegeService;

@RestController
@RequestMapping("/previlege")
@CrossOrigin("*")



public class PrevilegeController {
	
	@Autowired
	private PrevilegeService previlegeService;
	
	
	@PostMapping()
	private MessageResponse save(@RequestBody Previlege previlege) {
		return previlegeService.save(previlege);
	}
	@PutMapping()
	private MessageResponse update(@RequestBody Previlege previlege) {
		return previlegeService.update(previlege);
	}
	@DeleteMapping("/{id}")
	private MessageResponse delete(@PathVariable Integer id) {
		return previlegeService.delete(id);
	}
	@GetMapping
	private List<Previlege> findAll(){
		return previlegeService.findAll();
	}
	
}
