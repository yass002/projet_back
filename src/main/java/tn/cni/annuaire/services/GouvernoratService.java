package tn.cni.annuaire.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.annuaire.entities.Gouvernorat;
import tn.cni.annuaire.repositrories.GouvernoratRepository;
import tn.cni.annuaire.responses.MessageResponse;

@Service
public class GouvernoratService {

	
	@Autowired
	private GouvernoratRepository gouvernoratRepository;
	
	
	public MessageResponse save(Gouvernorat gouvernorat) {
		gouvernoratRepository.save(gouvernorat);
		return new MessageResponse(true , "Succéss" ,"Opération Efféctué");
	}
	public MessageResponse update(Gouvernorat gouvernorat) {
		gouvernoratRepository.save(gouvernorat);
		return new MessageResponse(true , "Succéss" ,"Opération Efféctué");
	}
	public MessageResponse delete(Integer id) {
		
		boolean exist = gouvernoratRepository.existsByIdAndDelegationsIsNotNull(id);
		if (exist) {
			return new MessageResponse(false , "Attention" , "Gouvernorat associé a un ou plusieurs delegations");
		}
		
	
				
		gouvernoratRepository.deleteById(id);
		return new MessageResponse(true , "Succéss" ,"Opération Efféctué");
	}
	public List<Gouvernorat> findAll(){
		return gouvernoratRepository.findAll();
	}
}
