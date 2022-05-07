package com.univ.rouen.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.univ.rouen.entity.AdminEntity;
import com.univ.rouen.entity.JouetEntity;
import com.univ.rouen.entity.LutinEntity;

/**
 * Dto commande
 * @author GROUPE JEE
 */
public class CommandeDto {
	private Long id;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private List<JouetEntity>jouets;
	private List<LutinEntity> lutins;

	public CommandeDto(Long id,LocalDate dateDebut, LocalDate dateFin, List<JouetEntity>jouets, List<LutinEntity>lutins) {
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.jouets = jouets;
		this.lutins = lutins;
		
	}
	public List<JouetEntity> getJouets() {
		return jouets;
	}
	public void setJouets(List<JouetEntity> jouets) {
		this.jouets = jouets;
	}
	public List<LutinEntity> getLutins() {
		return lutins;
	}
	public void setLutins(List<LutinEntity> lutins) {
		this.lutins = lutins;
	}
	public CommandeDto() {
		
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
