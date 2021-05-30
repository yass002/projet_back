package tn.cni.annuaire.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.annuaire.entities.Role;
import tn.cni.annuaire.repositrories.RoleRepository;
import tn.cni.annuaire.responses.MessageResponse;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	
	public MessageResponse save(Role role) {
		 roleRepository.save(role);
		 return new MessageResponse(true, "Succès", "Opération Effectué");
	}
	public MessageResponse update(Role role) {
		 roleRepository.save(role);
		 return new MessageResponse(true, "Succès", "Opération Effectué");
	}
	public MessageResponse delete(Integer Id) {
		
		
		 roleRepository.deleteById(Id);
		 return new MessageResponse(true, "Succès", "Opération Effectué");
	}
	public List<Role> findAll(){
		return roleRepository.findAll();
	}
	
	
}
