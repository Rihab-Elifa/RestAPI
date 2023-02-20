package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employe{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String fonction;
	@ManyToOne
	@JoinColumn(name="d_id")
	private Departement d;
	
	public Employe() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	public Employe(Integer id, String nom, String fonction, Departement d) {
		super();
		this.id = id;
		this.nom = nom;
		this.fonction = fonction;
		this.d = d;
	}
	public Departement getD() {
		return d;
	}
	public void setD(Departement d) {
		this.d = d;
	}
	


}
