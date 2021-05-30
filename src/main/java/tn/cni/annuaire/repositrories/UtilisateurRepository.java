package tn.cni.annuaire.repositrories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cni.annuaire.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{

}
