package tn.cni.annuaire.repositrories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cni.annuaire.entities.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
