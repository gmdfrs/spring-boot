package com.univ.rouen.controller;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.univ.rouen.dto.AdminDto;
import com.univ.rouen.dto.LutinDto;
import com.univ.rouen.entity.AdminEntity;
import com.univ.rouen.service.AdminService;

/**
 * Controller pour admin
 * @author GROUPE JEE
 */

@RestController
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	// find admin
	@GetMapping
	public List<AdminEntity> getAdmin(){
		
		return adminService.findAdmin();
	}
	
	// update un lutin
	@PutMapping("/updateAdmin")
	public ResponseEntity<AdminDto> updateAdmin(@RequestBody AdminDto adminDto) throws Exception {

		if(!adminService.existsById(adminDto.getId()) && adminDto.getId() != 1)
		{
			return new ResponseEntity<AdminDto>(HttpStatus.NOT_FOUND);
		}
		
		if(adminService.existsByEmail(adminDto.getEmail()) && !adminService.findAdminById(adminDto.getId()).getEmail().equals(adminDto.getEmail()))
		{
			return new ResponseEntity<AdminDto>(HttpStatus.CONFLICT);
		}

		AdminEntity cmdRequest = mapAdminDtoToAdminEntity(adminDto);
		AdminEntity response = adminService.updateAdmin(cmdRequest);
		
		if(response == null) {
			return new ResponseEntity<AdminDto>(HttpStatus.NOT_MODIFIED);
		}

		return new ResponseEntity<AdminDto>(mapAdminEntityToAdminDto(response),HttpStatus.OK);
	}
	
	/***Transfoler un admin en une adminDto**/
	private AdminDto mapAdminEntityToAdminDto(AdminEntity admin) {
		ModelMapper mapper = new ModelMapper();
		AdminDto adminDto =mapper.map(admin, AdminDto.class);
		return adminDto;
	}
	/***transformer une adminDto en un adminEntity **/
	private AdminEntity mapAdminDtoToAdminEntity(AdminDto adminDto) {
		ModelMapper mapper =new ModelMapper();
		AdminEntity  admin = mapper.map(adminDto, AdminEntity.class);
		return admin;
	}	
}
