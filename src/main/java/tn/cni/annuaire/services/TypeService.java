package tn.cni.annuaire.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.annuaire.entities.Delegation;
import tn.cni.annuaire.entities.Gouvernorat;
import tn.cni.annuaire.entities.Type;
import tn.cni.annuaire.repositrories.TypeRepository;
import tn.cni.annuaire.responses.MessageResponse;

@Service
public class TypeService {
	@Autowired
	private TypeRepository typeRepository;
public MessageResponse save(Type type){
		
	typeRepository.save(type);
		
		return new MessageResponse(true, "Succès", "Opération Effectué");
		
	}
	
	public MessageResponse update(Type type){
		
		typeRepository.save(type);
		
		return new MessageResponse(true, "Succès", "Opération Effectué");
		
	}
	
	public MessageResponse delete(Integer id){
		
		typeRepository.deleteById(id);
		
		return new MessageResponse(true, "Succès", "Opération Effectué");
		
	}
	public List<Type> findAll(){
		return typeRepository.findAll();
	}
	
}
