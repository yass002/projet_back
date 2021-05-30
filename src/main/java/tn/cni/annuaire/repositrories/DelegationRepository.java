package tn.cni.annuaire.repositrories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cni.annuaire.entities.Delegation;
import tn.cni.annuaire.entities.Gouvernorat;

public interface DelegationRepository  extends JpaRepository<Delegation, Integer>{

	List<Delegation> findByGouvernorat(Gouvernorat gouvernorat);
	public boolean existsByIdAndStructuresIsNotNull(Integer id);
}
