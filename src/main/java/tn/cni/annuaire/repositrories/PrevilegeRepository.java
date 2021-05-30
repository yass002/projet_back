package tn.cni.annuaire.repositrories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cni.annuaire.entities.Previlege;

public interface PrevilegeRepository extends JpaRepository<Previlege, Integer> {


	boolean existsByIdAndRolesNotNull(Integer id);

}
