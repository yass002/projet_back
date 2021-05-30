package tn.cni.annuaire.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.annuaire.entities.Application;
import tn.cni.annuaire.repositrories.ApplicationRepository;
import tn.cni.annuaire.responses.MessageResponse;

@Service
public class ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;
	
public MessageResponse save(Application application){
		
		applicationRepository.save(application);
		
		return new MessageResponse(true, "Succès", "Opération Effectué");
		
}

public MessageResponse update(Application application) {
	applicationRepository.save(application);
	return new MessageResponse(true,"Succés","Opération Effectué");
}
public MessageResponse delete(Integer Id) {
	applicationRepository.deleteById(Id);
		return new MessageResponse(true,"Succés","Opération Effectué");
}
public List<Application> findAll(){
	return applicationRepository.findAll();
}
}
