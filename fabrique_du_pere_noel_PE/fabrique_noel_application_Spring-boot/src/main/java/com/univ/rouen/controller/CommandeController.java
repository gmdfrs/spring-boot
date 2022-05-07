package com.univ.rouen.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import com.univ.rouen.dto.CommandeDto;
import com.univ.rouen.entity.CommandeEntity;
import com.univ.rouen.service.CommandeService;
/**
 * Controller pour commande
 * @author GROUPE JEE
 */
@RestController
@RequestMapping("/commande")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommandeController {
	public static final Logger LOGGER = LoggerFactory.getLogger(CommandeController.class);
	@Autowired
	private CommandeService commandeService;
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public 	List<CommandeEntity> listCommande(){
		
		return commandeService.findAll();
	}

	@GetMapping("/{id}")
	@PreAuthorize("isAuthentificated()")
	public CommandeEntity getCommande(@PathVariable Long id){
		return commandeService.findCommandeById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addCommande")
	public ResponseEntity<CommandeDto> createCommande(@RequestBody CommandeDto commandeDto) {
		CommandeEntity commande  = commandeService.findCommandeById(commandeDto.getId());
		if(commande != null) {
			return new ResponseEntity<CommandeDto>(HttpStatus.CONFLICT);
		}
		CommandeEntity cmd = mapCommandeDtoToCommandeEntity(commandeDto);
		CommandeEntity response = commandeService.saveCommande(cmd);
		if(response == null) {
			return new ResponseEntity<CommandeDto>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<CommandeDto>(mapCommandeEntityToCommandeDto(response),HttpStatus.CREATED);

	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/updateCommande")
	public ResponseEntity<CommandeDto> updateCommande(@RequestBody CommandeDto commandeDto) {
		if(!commandeService.checkIfIdexists(commandeDto.getId()))
		{
			return new ResponseEntity<CommandeDto>(HttpStatus.NOT_FOUND);
		}

		CommandeEntity cmdRequest = mapCommandeDtoToCommandeEntity(commandeDto);
		CommandeEntity response = commandeService.updateCommande(cmdRequest);
		if(response == null) {
			return new ResponseEntity<CommandeDto>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<CommandeDto>(mapCommandeEntityToCommandeDto(response),HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/deleteCommande/{commandeId}")
	public ResponseEntity<String> deleteCommande(@PathVariable Long commandeId ){
		commandeService.deleteCommande(commandeId);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	/***Transformer une Commande en une CommandeDto**/
	private CommandeDto mapCommandeEntityToCommandeDto(CommandeEntity commande) {
		ModelMapper mapper = new ModelMapper();
		CommandeDto commandeDto =mapper.map(commande, CommandeDto.class);
		return commandeDto;
	}
	/***transformer une CommandeDto en un CommandeEntity **/
	private CommandeEntity mapCommandeDtoToCommandeEntity(CommandeDto commandeDto) {
		ModelMapper mapper =new ModelMapper();
		CommandeEntity  commande = mapper.map(commandeDto, CommandeEntity.class);
		return commande;
	}
}
