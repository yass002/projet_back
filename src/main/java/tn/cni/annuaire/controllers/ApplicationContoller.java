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

import tn.cni.annuaire.entities.Application;
import tn.cni.annuaire.responses.MessageResponse;
import tn.cni.annuaire.services.ApplicationService;

@RestController
@RequestMapping("/application")
@CrossOrigin("*")
public class ApplicationContoller {
	@Autowired
	private ApplicationService applicationService;
	
	@PostMapping
	public MessageResponse save(@RequestBody Application application) {
		return applicationService.save(application);
	}
	@PutMapping
	public MessageResponse update(@RequestBody Application application) {
		return applicationService.update(application);
	}
	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable Integer id) {
		return applicationService.delete(id);
	}
	@GetMapping
	public List<Application> findAll() {
		return applicationService.findAll();
	}

}
