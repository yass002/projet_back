package tn.cni.annuaire.repositrories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cni.annuaire.entities.Structure;

public interface StructureRepository  extends JpaRepository<Structure, Integer>{

	List<Structure> findByParentIsNull();

	boolean existsByNom(String nom);

	boolean existsByCode(Integer code);

	List<Structure> findByParent(Structure parent);

	boolean existsByCodeAndId(Integer code, Integer id);

	boolean existsByNomAndId(String nom, Integer id);


}
