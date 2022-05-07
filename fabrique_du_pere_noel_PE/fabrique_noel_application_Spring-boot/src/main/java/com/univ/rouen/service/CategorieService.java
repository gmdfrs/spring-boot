package com.univ.rouen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univ.rouen.entity.CategorieEntity;
import com.univ.rouen.repository.CategorieRepository;

/**
 * Service pour categorie
 * @author GROUPE JEE
 */
@Service
public class CategorieService implements ICategorieService {

	@Autowired
	private CategorieRepository categRep;

	@Override
	public CategorieEntity saveCategorie(CategorieEntity categorie) {
		return	categRep.save(categorie);

	}

	@Override
	public CategorieEntity updateCategorie(CategorieEntity categorie) {
		return categRep.save(categorie);

	}

	@Override
	public void deleteCategorie(Long categorieId) {
		categRep.deleteById(categorieId);

	}

	@Override
	public CategorieEntity findCategorieById(Long categorieId) {
		return categRep.findById(categorieId).orElse(null);
	}

	@Override
	public List<CategorieEntity> findAll() {
		return	categRep.findAll();

	}

	@Override
	public boolean checkIfIdexists(Long id) {
		return categRep.existsById(id);
	}

}
