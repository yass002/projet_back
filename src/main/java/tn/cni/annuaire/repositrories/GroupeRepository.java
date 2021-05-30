package tn.cni.annuaire.repositrories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cni.annuaire.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Integer> {

}
