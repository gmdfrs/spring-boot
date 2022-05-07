package com.univ.rouen.service;

import java.util.List;

import com.univ.rouen.entity.CatalogueEntity;

/**
 * Service pour icatalogue
 * @author GROUPE JEE
 */
public interface ICatalogueService {
	public CatalogueEntity saveCatalogue(CatalogueEntity catalogue);
	public CatalogueEntity updateCatalogue(CatalogueEntity catalogue);
	public void deleteCatalogue(Long catalogueId);
	public CatalogueEntity findCatalogueById(Long catalogueId);
	public List<CatalogueEntity> findAll();
	public boolean checkIfIdexists(Long id);
}
