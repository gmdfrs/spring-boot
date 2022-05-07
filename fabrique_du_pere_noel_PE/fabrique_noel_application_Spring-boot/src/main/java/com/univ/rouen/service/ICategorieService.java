package com.univ.rouen.service;

import java.util.List;

import com.univ.rouen.entity.CategorieEntity;

/**
 * Service pour icategorie
 * @author GROUPE JEE
 */
public interface ICategorieService {
	public CategorieEntity saveCategorie(CategorieEntity categorie);
	public CategorieEntity updateCategorie(CategorieEntity categorie);
	public void deleteCategorie(Long categorieId);
	public CategorieEntity findCategorieById(Long categorieId);
	public List<CategorieEntity> findAll();
	public boolean checkIfIdexists(Long id);
}
