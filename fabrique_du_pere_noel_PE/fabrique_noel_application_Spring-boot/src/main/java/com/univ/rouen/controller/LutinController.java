package com.univ.rouen.controller;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.univ.rouen.dto.LutinDto;
import com.univ.rouen.entity.LutinEntity;
import com.univ.rouen.service.LutinService;

/**
 * Controller pour lutin
 * @author GROUPE JEE
 */

@RestController
@CrossOrigin()
@RequestMapping("/lutin")
public class LutinController {

	@Autowired
	private LutinService lutinService;
	// get la liste des lutin
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public List<LutinEntity> listLutin() {
		
		// Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    // System.out.println("authentication.getAuthorities" + authentication.getAuthorities());
		return lutinService.findAll();
	}
	
	// get un lutin avec son id
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<LutinEntity> getLutin(@PathVariable Long id){
		
		if(!lutinService.existsById(id))
		{
			return new ResponseEntity<LutinEntity>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<LutinEntity>(lutinService.findLutinById(id), HttpStatus.OK);
	}
	
	// ajouter un lutin
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/addLutin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LutinDto> createLutin(@RequestBody LutinDto lutinDto) throws Exception{

		LutinEntity lutin  = lutinService.findLutinById(lutinDto.getId());

		if(lutin != null || lutinService.existsByEmail(lutinDto.getEmail())) {
			return new ResponseEntity<LutinDto>(HttpStatus.CONFLICT);
		}
	
		LutinEntity ltn = mapLutinDtoToLutinEntity(lutinDto);
		LutinEntity response = lutinService.saveLutin(ltn);
		if(response == null) {
			return new ResponseEntity<LutinDto>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<LutinDto>(mapLutinEntityToLutinDto(response),HttpStatus.CREATED);
	}
	
	
	// update un lutin
	@PutMapping("/updateLutin")
	@PreAuthorize("isAuthentificated()")
	public ResponseEntity<LutinDto> updateLutin(@RequestBody LutinDto lutinDto) throws Exception {

		if(!lutinService.existsById(lutinDto.getId()))
		{
			return new ResponseEntity<LutinDto>(HttpStatus.NOT_FOUND);
		}
		
		if(lutinService.existsByEmail(lutinDto.getEmail()) && !lutinService.findLutinById(lutinDto.getId()).getEmail().equals(lutinDto.getEmail()))
		{
			return new ResponseEntity<LutinDto>(HttpStatus.CONFLICT);
		}

		LutinEntity cmdRequest = mapLutinDtoToLutinEntity(lutinDto);
		LutinEntity response = lutinService.updateLutin(cmdRequest);
		
		if(response == null) {
			return new ResponseEntity<LutinDto>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<LutinDto>(mapLutinEntityToLutinDto(response),HttpStatus.OK);
	}
	
	// delete un lutin
	@DeleteMapping("/deleteLutin/{lutinId}")
	public ResponseEntity<String> deleteLutin(@PathVariable Long lutinId ){
		
		if(!lutinService.existsById(lutinId))
		{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
		lutinService.deleteLutin(lutinId);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	/***Transfoler un Lutin en une CommandeDto**/
	private LutinDto mapLutinEntityToLutinDto(LutinEntity lutin) {
		ModelMapper mapper = new ModelMapper();
		LutinDto lutinDto =mapper.map(lutin, LutinDto.class);
		return lutinDto;
	}
	/***transformer une lutinDto en un lutinEntity **/
	private LutinEntity mapLutinDtoToLutinEntity(LutinDto lutinDto) {
		ModelMapper mapper =new ModelMapper();
		LutinEntity  lutin = mapper.map(lutinDto, LutinEntity.class);
		return lutin;
	}
}
