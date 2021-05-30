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
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Groupe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String nomAr;
	private String nomFr;
	@OneToMany(mappedBy = "groupe")
	private List<Utilisateur> users;
	
	@ManyToMany( cascade = CascadeType.ALL)
	  @JoinTable( joinColumns = { 
	            @JoinColumn(name = "groupes_id", nullable = false, updatable = false) }, 
	            inverseJoinColumns = { @JoinColumn(name = "applications_id", 
	                    nullable = false, updatable = false) })
	private List<Application> applications;
}
