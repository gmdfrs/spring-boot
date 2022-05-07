package com.univ.rouen.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity commande
 * @author GROUPE JEE
 */
@Entity
@Table(name="commande")
public class CommandeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateDebut;
	private Date dateFin;
	@OneToMany
	private List<JouetEntity>jouets;
	@OneToMany
	private List<LutinEntity> lutins;
	public CommandeEntity(long id, Date dateDebut, Date dateFin,List<JouetEntity>jouets,List<LutinEntity>lutins) {
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
	public CommandeEntity() {

	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
}
