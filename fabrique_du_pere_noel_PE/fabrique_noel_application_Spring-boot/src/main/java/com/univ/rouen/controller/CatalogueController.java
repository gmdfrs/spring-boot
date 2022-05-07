package com.univ.rouen.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univ.rouen.entity.CatalogueEntity;
import com.univ.rouen.service.CatalogueService;

/**
 * Controller pour catalogue
 * @author GROUPE JEE
 */
@RestController
@RequestMapping("catalogues")
@PreAuthorize("hasRole('ADMIN')")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CatalogueController {

	@Autowired
	public CatalogueService catalogueServ;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CatalogueController.class);

	@GetMapping
	public 	List<CatalogueEntity> listCatalogue(){
		return catalogueServ.findAll();
	}

	@GetMapping("/{id}")
	public CatalogueEntity getCatalogue(@PathVariable Long id){
		return catalogueServ.findCatalogueById(id);
	}

	@PostMapping("/addCatalogue")
	public ResponseEntity<CatalogueEntity> createCatalogue(@RequestBody CatalogueEntity catalogue) {
		if(catalogueServ.checkIfIdexists(catalogue.getId())) {
			return new ResponseEntity<CatalogueEntity>(HttpStatus.CONFLICT);
		}
		CatalogueEntity response = catalogueServ.saveCatalogue(catalogue);
		if(response == null) {
			return new ResponseEntity<CatalogueEntity>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<CatalogueEntity>(response,HttpStatus.CREATED);

	}
	
	@PutMapping("/updateCatalogue")
	public ResponseEntity<CatalogueEntity> updateCatalogue(@RequestBody CatalogueEntity catalogue) {
		if(!catalogueServ.checkIfIdexists(catalogue.getId()))
		{
			return new ResponseEntity<CatalogueEntity>(HttpStatus.NOT_FOUND);
		}

		CatalogueEntity response = catalogueServ.updateCatalogue(catalogue);
		if(response == null) {
			return new ResponseEntity<CatalogueEntity>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<CatalogueEntity>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCatalogue/{catalogueId}")
	public ResponseEntity<String> deleteCatalogue(@PathVariable Long catalogueId ){
		catalogueServ.deleteCatalogue(catalogueId);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
}
