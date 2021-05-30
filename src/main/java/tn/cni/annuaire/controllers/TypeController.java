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
import tn.cni.annuaire.entities.Type;
import tn.cni.annuaire.responses.MessageResponse;
import tn.cni.annuaire.services.TypeService;

@RestController
@RequestMapping("/type")
@CrossOrigin("*")
public class TypeController {
	@Autowired
	private TypeService typeService;
	@PostMapping()
	public MessageResponse save(@RequestBody Type type) {
		return typeService.save(type);
	}
	@PutMapping()
	public MessageResponse update(@RequestBody	 Type type) {
		return typeService.update(type);
	}
	@DeleteMapping("/{id}")
	public MessageResponse delete(@PathVariable Integer id) {
		return typeService.delete(id);
	}
	
	@GetMapping()
	public List<Type> findAll() {
		return typeService.findAll();
	}
}
