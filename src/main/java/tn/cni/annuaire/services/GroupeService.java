package tn.cni.annuaire.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.annuaire.entities.Groupe;
import tn.cni.annuaire.repositrories.GroupeRepository;
import tn.cni.annuaire.responses.MessageResponse;

@Service
public class GroupeService  {
	@Autowired
	private GroupeRepository groupeRepository;
	
	public MessageResponse save(Groupe groupe){
//		groupe.getApplications().forEach(a-> System.out.println(a.getNomFr()));
//		groupe.setApplications(groupe.getApplications());
		groupeRepository.save(groupe);
		
		return new MessageResponse(true, "Succès", "Opération Effectué");
		
	}
	
	public MessageResponse update(Groupe groupe){
		
		groupeRepository.save(groupe);
		
		return new MessageResponse(true, "Succès", "Opération Effectué");
		
	}
	
	public MessageResponse delete(Integer id){
		
		groupeRepository.deleteById(id);
		
		return new MessageResponse(true, "Succès", "Opération Effectué");
		
	}
	public List<Groupe> findAll(){
		return groupeRepository.findAll();
	}

}
