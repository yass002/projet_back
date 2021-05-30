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

import tn.cni.annuaire.entities.Role;
import tn.cni.annuaire.responses.MessageResponse;
import tn.cni.annuaire.services.RoleService;

@RestController
@RequestMapping("/role")
@CrossOrigin("*")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@PostMapping
	private MessageResponse save(@RequestBody Role role) {
		return roleService.save(role);
	}
	@PutMapping
	private MessageResponse update(@RequestBody Role role) {
		return roleService.update(role);
	}
	@DeleteMapping("/{id}")
	private MessageResponse delete(@PathVariable Integer id) {
		return roleService.delete(id);
	}
	@GetMapping
	private List<Role> findAll(){
		return roleService.findAll();
	}
	
	
}
