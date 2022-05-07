package com.univ.rouen.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univ.rouen.dto.CompetenceDto;
import com.univ.rouen.entity.CompetenceEntity;
import com.univ.rouen.entity.CommandeEntity;
import com.univ.rouen.repository.CompetenceRepository;
import com.univ.rouen.service.CompetenceService;
import com.univ.rouen.service.CommandeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/competences")
public class CompetenceController {
	@Autowired
	public CompetenceService competenceServ;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CompetenceController.class);
	
	
	@GetMapping
	public 	List<CompetenceEntity> listCompetence(){
		return competenceServ.findAll();
	}

	@GetMapping("/{id}")
	public CompetenceEntity getCompetence(@PathVariable Long id){
		return competenceServ.findCompetenceById(id);
	}

	@PostMapping("/addCompetence")
	public ResponseEntity<CompetenceEntity> createCompetence(@RequestBody CompetenceEntity competence) {
		if(competenceServ.checkIfIdexists(competence.getId())) {
			return new ResponseEntity<CompetenceEntity>(HttpStatus.CONFLICT);
		}
		CompetenceEntity response = competenceServ.saveCompetence(competence);
		if(response == null) {
			return new ResponseEntity<CompetenceEntity>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<CompetenceEntity>(response,HttpStatus.CREATED);

	}
	
	
	@PutMapping("/updateCompetence")
	public ResponseEntity<CompetenceEntity> updateCompetence(@RequestBody CompetenceEntity competence) {
		if(!competenceServ.checkIfIdexists(competence.getId()))
		{
			return new ResponseEntity<CompetenceEntity>(HttpStatus.NOT_FOUND);
		}

		CompetenceEntity response = competenceServ.updateCompetence(competence);
		if(response == null) {
			return new ResponseEntity<CompetenceEntity>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<CompetenceEntity>(response,HttpStatus.OK);
	}
	@DeleteMapping("/deleteCompetence/{competenceId}")
	public ResponseEntity<String> deleteCompetence(@PathVariable Long competenceId ){
		competenceServ.deleteCompetence(competenceId);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
}
