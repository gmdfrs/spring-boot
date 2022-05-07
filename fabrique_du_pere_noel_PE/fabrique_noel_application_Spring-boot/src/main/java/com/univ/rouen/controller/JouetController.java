package com.univ.rouen.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.univ.rouen.dto.CommandeDto;
import com.univ.rouen.dto.JouetDto;
import com.univ.rouen.entity.CommandeEntity;
import com.univ.rouen.entity.JouetEntity;
import com.univ.rouen.service.CommandeService;
import com.univ.rouen.service.JouetService;
/**
 * Controller pour jouet
 * @author GROUPE JEE
 */
@RestController
@RequestMapping("/jouets")
@CrossOrigin("*")
public class JouetController {
	
	@Autowired
	public JouetService jouetServ;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(JouetController.class);

	@GetMapping
	public 	List<JouetEntity> listJouet(){
		return jouetServ.findAll();
	}
	@GetMapping("/jouetWithCommandNull")
	public 	List<JouetEntity> listJouetWithCommandNull(){
		return jouetServ.findAll();
	}

	@GetMapping("/{id}")
	public JouetEntity getJouet(@PathVariable Long id){
		return jouetServ.findJouetById(id);
	}

	@PostMapping("/addJouet")
	public ResponseEntity<JouetEntity> createJouet(@RequestBody JouetEntity jouet) {
		if(jouetServ.checkIfIdexists(jouet.getId())) {
			return new ResponseEntity<JouetEntity>(HttpStatus.CONFLICT);
		}
		JouetEntity response = jouetServ.saveJouet(jouet);
		if(response == null) {
			return new ResponseEntity<JouetEntity>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<JouetEntity>(response,HttpStatus.CREATED);

	}
	
	
	@PutMapping("/updateJouet")
	public ResponseEntity<JouetEntity> updateJouet(@RequestBody JouetEntity jouet) {
		if(!jouetServ.checkIfIdexists(jouet.getId()))
		{
			return new ResponseEntity<JouetEntity>(HttpStatus.NOT_FOUND);
		}

		JouetEntity response = jouetServ.updateJouet(jouet);
		if(response == null) {
			return new ResponseEntity<JouetEntity>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<JouetEntity>(response,HttpStatus.OK);
	}
	@DeleteMapping("/deleteJouet/{jouetId}")
	public ResponseEntity<String> deleteJouet(@PathVariable Long jouetId ){
		jouetServ.deleteJouet(jouetId);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

}