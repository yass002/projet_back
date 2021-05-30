package tn.cni.annuaire.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String nom;

	@ManyToMany( cascade = CascadeType.ALL)
	  @JoinTable( joinColumns = { 
	            @JoinColumn(name = "roles_id", nullable = false, updatable = false) }, 
	            inverseJoinColumns = { @JoinColumn(name = "previleges_id", 
	                    nullable = false, updatable = false) })
	private List<Previlege> previleges;
}
