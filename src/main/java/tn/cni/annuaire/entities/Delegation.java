package tn.cni.annuaire.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Delegation {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	private String nomFr;
	private String nomAr;
	@ManyToOne
	private Gouvernorat gouvernorat;
	
	
	
	
	
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "delegation")
	private List<Structure> structures ;
}
