package tn.cni.annuaire.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.annuaire.entities.Utilisateur;
import tn.cni.annuaire.repositrories.UtilisateurRepository;
import tn.cni.annuaire.responses.MessageResponse;

@Service
public class UtilisateurService {

		@Autowired
		private UtilisateurRepository utilisateurRepository;
		
	public MessageResponse save(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
		return  new MessageResponse(true,"succéss" , "Opération Effectué");
	}
	public MessageResponse update(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
		return  new MessageResponse(true,"succéss" , "Opération Effectué");
	}
	public MessageResponse delete(Integer id ) {
		utilisateurRepository.deleteById(id);
		return  new MessageResponse(true,"succéss" , "Opération Effectué");
	}
	public List<Utilisateur> findAll(){
		return utilisateurRepository.findAll();
	}
	public Utilisateur getById(Integer id) {
		return utilisateurRepository.findById(id).orElse(null);
	}
}
