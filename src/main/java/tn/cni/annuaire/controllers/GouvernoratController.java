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

import tn.cni.annuaire.entities.Gouvernorat;
import tn.cni.annuaire.responses.MessageResponse;
import tn.cni.annuaire.services.GouvernoratService;

@RestController
@RequestMapping("/gouvernorat")
@CrossOrigin("*")
public class GouvernoratController {
		@Autowired
		private GouvernoratService gouvernoratService;
		
		@PostMapping
		private MessageResponse save(@RequestBody Gouvernorat gouvernorat) {
			return gouvernoratService.save(gouvernorat);
		}
		@PutMapping
		private MessageResponse update(@RequestBody Gouvernorat gouvernorat) {
			return gouvernoratService.update(gouvernorat);
		}
		@DeleteMapping("/{id}")
		private MessageResponse delete(@PathVariable Integer id){
			return gouvernoratService.delete(id);
		}
		@GetMapping()
		private List<Gouvernorat> findAll(){
			return gouvernoratService.findAll();
		}
}