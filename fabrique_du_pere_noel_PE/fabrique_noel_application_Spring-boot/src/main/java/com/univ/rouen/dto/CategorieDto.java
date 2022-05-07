package com.univ.rouen.dto;

/**
 * Dto categorie
 * @author GROUPE JEE
 */
import java.util.List;

import com.univ.rouen.entity.JouetEntity;

public class CategorieDto {
	private String nom;
	private List<JouetEntity> jouets;
	
	
	public CategorieDto() {}

	public CategorieDto(String nom, List<JouetEntity> jouets) {
		super();
		this.nom = nom;
		this.jouets = jouets;
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
	
	@Override
	public String toString() {
		return "CategorieDto [nom=" + nom + ", jouets=" + jouets + "]";
	}
}
