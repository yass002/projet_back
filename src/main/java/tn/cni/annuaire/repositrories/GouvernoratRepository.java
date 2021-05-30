package tn.cni.annuaire.repositrories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cni.annuaire.entities.Gouvernorat;

public interface GouvernoratRepository  extends JpaRepository<Gouvernorat, Integer>{

	public boolean existsByIdAndDelegationsIsNotNull(Integer id);
	
}
