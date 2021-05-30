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

import tn.cni.annuaire.dto.TreeNode;
import tn.cni.annuaire.entities.Structure;
import tn.cni.annuaire.responses.MessageResponse;
import tn.cni.annuaire.responses.StructureResponse;
import tn.cni.annuaire.services.StructureService;

@RestController
@RequestMapping("/structure")
@CrossOrigin("*")
public class StructureController {

	
		@Autowired
		private StructureService structureService;

		@PostMapping()
		public MessageResponse save(@RequestBody Structure structure) {
			return structureService.save(structure);
		}
		@PutMapping()
		public MessageResponse update(@RequestBody	 Structure structure) {
			return structureService.update(structure);
		}
		@DeleteMapping("/{id}")
		public MessageResponse delete(@PathVariable Integer id) {
			return structureService.delete(id);
		}
		
		@GetMapping()
		public List<StructureResponse> findAll() {
			return structureService.findAll();
		}
		@GetMapping("/{id}")
		public Structure findById(@PathVariable Integer id) {
			return structureService.getById(id);
		}
		
		@GetMapping("/parent")
		public List<Structure> findParent() {
			return structureService.findParent();
		}
		@GetMapping("/parent/{id}")
		public List<Structure> findByParent(@PathVariable Integer id) {
			return structureService.findByParent(id);
		}
		
		
		@GetMapping("/tree")
		public List<TreeNode> getStructure() {
			return structureService.getStructure();
		}
}
