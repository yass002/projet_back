package tn.cni.annuaire.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private String cin; 
	private String nom;
	private String prenom ;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String adresse;
	private String cnrps ; 
	
	private String position;
	private String grade ;
	private String fonction;
	private String mail;
	private String tel;


	private String username;
	@Transient
	private String password;
	@ManyToOne
	private Groupe groupe;
}
