package com.univ.rouen.entity;

import java.util.List;

import javax.persistence.*;

/**
 * Entity jouet
 * @author GROUPE JEE
 */
@Entity
@Table(name="jouet")
public class JouetEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	@ManyToOne
	private LutinEntity lutin;
	
	@ManyToOne
	private CategorieEntity categorie;
	
	@ManyToOne
	private CatalogueEntity catalogue;
	
	@ManyToOne
	private CommandeEntity commande;

	@ManyToMany
	private List<CompetenceEntity> competences;

	public JouetEntity() {
		
	}

	public JouetEntity(Long id, String nom, LutinEntity latin, CategorieEntity categorie, CatalogueEntity catalogue, CommandeEntity commande,
			List<CompetenceEntity> competences) {
		super();
		this.id = id;
		this.nom = nom;
		this.lutin = latin;
		this.categorie = categorie;
		this.catalogue = catalogue;
		this.commande = commande;
		this.competences = competences;
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

	public LutinEntity getLatin() {
		return lutin;
	}

	public void setLatin(LutinEntity latin) {
		this.lutin = latin;
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
