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

@Data
@Entity
public class Structure {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	private String nom;
	private Integer code;
	private String acronyme;
	private String adresse;
	private String mail;
	private String tel;
	private String rue;
	private Integer codePostal;
	private String siteWeb;
	@ManyToOne
	private Structure parent;
	@ManyToOne
	private Delegation delegation;
	
	@ManyToOne
	private Type type;
	
}
