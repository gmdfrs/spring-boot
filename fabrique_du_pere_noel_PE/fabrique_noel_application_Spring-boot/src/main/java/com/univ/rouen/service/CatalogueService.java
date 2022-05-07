package com.univ.rouen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univ.rouen.entity.CatalogueEntity;
import com.univ.rouen.repository.CatalogueRepository;

/**
 * Service pour catalogue
 * @author GROUPE JEE
 */
@Service
public class CatalogueService implements ICatalogueService {

	@Autowired
	private CatalogueRepository categRep;

	@Override
	public CatalogueEntity saveCatalogue(CatalogueEntity catalogue) {
		return	categRep.save(catalogue);

	}

	@Override
	public CatalogueEntity updateCatalogue(CatalogueEntity catalogue) {
		return categRep.save(catalogue);

	}

	@Override
	public void deleteCatalogue(Long catalogueId) {
		categRep.deleteById(catalogueId);

	}

	@Override
	public CatalogueEntity findCatalogueById(Long catalogueId) {
		return categRep.findById(catalogueId).orElse(null);
	}

	@Override
	public List<CatalogueEntity> findAll() {
		return	categRep.findAll();

	}

	@Override
	public boolean checkIfIdexists(Long id) {
		return categRep.existsById(id);
	}

}
