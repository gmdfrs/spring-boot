package com.univ.rouen.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity categorie
 * @author GROUPE JEE
 */
@Entity
@Table(name="categorie")
public class CategorieEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	
	@OneToMany
	private List<JouetEntity> jouets;

	public CategorieEntity() {
	
	}

	public CategorieEntity(Long id, String nom, List<JouetEntity> jouets) {
		super();
		this.id = id;
		this.nom = nom;
		this.jouets = jouets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<JouetEntity> getJouets() {
		return jouets;
	}

	public void setJouets(List<JouetEntity> jouets) {
		this.jouets = jouets;
	}

}
