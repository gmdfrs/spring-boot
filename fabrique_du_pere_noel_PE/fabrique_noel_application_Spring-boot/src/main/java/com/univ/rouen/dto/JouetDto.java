package com.univ.rouen.dto;

import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.univ.rouen.entity.CatalogueEntity;
import com.univ.rouen.entity.CategorieEntity;
import com.univ.rouen.entity.CommandeEntity;
import com.univ.rouen.entity.CompetenceEntity;
import com.univ.rouen.entity.LutinEntity;

/**
 * Dto jouet
 * @author GROUPE JEE
 */
public class JouetDto {
	private Long id;

	private String nom;
	private LutinEntity latin;
	private CategorieEntity categorie;
	private CatalogueEntity catalogue;
	private CommandeEntity commande;
	private List<CompetenceEntity> competences;
	
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
	public LutinEntity getLatin() {
		return latin;
	}
	public void setLatin(LutinEntity latin) {
		this.latin = latin;
	}
	public CategorieEntity getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieEntity categorie) {
		this.categorie = categorie;
	}
	public CatalogueEntity getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(CatalogueEntity catalogue) {
		this.catalogue = catalogue;
	}
	public CommandeEntity getCommande() {
		return commande;
	}
	public void setCommande(CommandeEntity commande) {
		this.commande = commande;
	}
	public List<CompetenceEntity> getCompetences() {
		return competences;
	}
	public void setCompetences(List<CompetenceEntity> competences) {
		this.competences = competences;
	}
}
