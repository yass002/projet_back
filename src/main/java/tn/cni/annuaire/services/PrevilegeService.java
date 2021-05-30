package tn.cni.annuaire.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.annuaire.entities.Previlege;
import tn.cni.annuaire.repositrories.PrevilegeRepository;
import tn.cni.annuaire.responses.MessageResponse;

@Service
public class PrevilegeService {
	@Autowired
	private PrevilegeRepository previlegeRepository;
	
	public MessageResponse save(Previlege previlege) {
		previlegeRepository.save(previlege);
		return new MessageResponse(true, "Succès", "Opération Effectué");
	}
	public MessageResponse update(Previlege previlege) {
		previlegeRepository.save(previlege);
		return new MessageResponse(true, "Succès", "Opération Effectué");
	}
	public MessageResponse delete(Integer id) {
		
		boolean exist = previlegeRepository.existsByIdAndRolesNotNull(id);
		if (exist) {
			 return new MessageResponse(false, "Attention", "Ce Previlege est associé a un ou plusieurs Role");
		}
		previlegeRepository.deleteById(id);
		return new MessageResponse(true, "Succès", "Opération Effectué");
	}
	
	public List<Previlege> findAll() {
		 return previlegeRepository.findAll();
	}
	
	
	
	
	
	
	
}
