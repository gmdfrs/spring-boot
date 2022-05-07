package com.univ.rouen.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity acompetence
 * @author GROUPE JEE
 */
@Entity
@Table(name="competence")
public class CompetenceEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;

	/*@OneToMany
	private List<JouetEntity> jouets;*/
	
//	@ManyToOne
//	private LutinEntity lutinCompetence;

	public CompetenceEntity() {
		
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

	/*public List<JouetEntity> getJouets() {
		return jouets;
	}

	public void setJouets(List<JouetEntity> jouets) {
		this.jouets = jouets;
	}
*/
/*	public CompetenceEntity(Long id, String nom, List<JouetEntity> jouets) {
		super();
		this.id = id;
		this.nom = nom;
		this.jouets = jouets;
	}*/
}