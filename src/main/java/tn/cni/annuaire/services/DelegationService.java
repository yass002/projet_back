package tn.cni.annuaire.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.annuaire.entities.Delegation;
import tn.cni.annuaire.entities.Gouvernorat;
import tn.cni.annuaire.repositrories.DelegationRepository;
import tn.cni.annuaire.responses.MessageResponse;

@Service
public class DelegationService {
	@Autowired
	private DelegationRepository delegationRepository;

	public MessageResponse save(Delegation delegation) {

		delegationRepository.save(delegation);

		return new MessageResponse(true, "Succès", "Opération Effectué");

	}

	public MessageResponse update(Delegation delegation) {

		delegationRepository.save(delegation);

		return new MessageResponse(true, "Succès", "Opération Effectué");

	}

	public MessageResponse delete(Integer id) {
		boolean exist = delegationRepository.existsByIdAndStructuresIsNotNull(id);
		if (exist) {
			return new MessageResponse(false, "Attention", "Delegation associé a un ou plusieurs Structures");
		}
		delegationRepository.deleteById(id);

		return new MessageResponse(true, "Succès", "Opération Effectué");

	}

	public List<Delegation> findAll() {
		return delegationRepository.findAll();
	}

	public List<Delegation> findByGouvernorat(Integer id) {
		Gouvernorat gouvernorat = new Gouvernorat();
		gouvernorat.setId(id);
		return delegationRepository.findByGouvernorat(gouvernorat);
	}

}
