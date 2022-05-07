package com.univ.rouen.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.univ.rouen.entity.CategorieEntity;
import com.univ.rouen.entity.CategorieEntity;
import com.univ.rouen.service.CategorieService;
import com.univ.rouen.service.CategorieService;

/**
 * Controller pour categorie
 * @author GROUPE JEE
 */
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategorieController {
	

	@Autowired
	public CategorieService categorieServ;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CategorieController.class);

	@GetMapping
	public 	List<CategorieEntity> listCategorie(){
		return categorieServ.findAll();
	}

	@GetMapping("/{id}")
	public CategorieEntity getCategorie(@PathVariable Long id){
		return categorieServ.findCategorieById(id);
	}

	@PostMapping("/addCategorie")
	public ResponseEntity<CategorieEntity> createCategorie(@RequestBody CategorieEntity categorie) {
		if(categorieServ.checkIfIdexists(categorie.getId())) {
			return new ResponseEntity<CategorieEntity>(HttpStatus.CONFLICT);
		}
		CategorieEntity response = categorieServ.saveCategorie(categorie);
		if(response == null) {
			return new ResponseEntity<CategorieEntity>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<CategorieEntity>(response,HttpStatus.CREATED);

	}
	
	
	@PutMapping("/updateCategorie")
	public ResponseEntity<CategorieEntity> updateCategorie(@RequestBody CategorieEntity categorie) {
		if(!categorieServ.checkIfIdexists(categorie.getId()))
		{
			return new ResponseEntity<CategorieEntity>(HttpStatus.NOT_FOUND);
		}

		CategorieEntity response = categorieServ.updateCategorie(categorie);
		if(response == null) {
			return new ResponseEntity<CategorieEntity>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<CategorieEntity>(response,HttpStatus.OK);
	}
	@DeleteMapping("/deleteCategorie/{categorieId}")
	public ResponseEntity<String> deleteCategorie(@PathVariable Long categorieId ){
		categorieServ.deleteCategorie(categorieId);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

}
