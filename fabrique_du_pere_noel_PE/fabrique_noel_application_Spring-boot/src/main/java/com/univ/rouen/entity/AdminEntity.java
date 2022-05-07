package com.univ.rouen.entity;

import java.util.List;

import javax.persistence.*;

/**
 * Entity admin
 * @author GROUPE JEE
 */
@Entity
@DiscriminatorValue("admin")
public class AdminEntity extends UserEntity{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	private List<CommandeEntity> commandes;

	public AdminEntity() {}

	public AdminEntity(Long id, List<CommandeEntity> commandes) {
		super();
		this.id = id;
		this.commandes = commandes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CommandeEntity> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<CommandeEntity> commandes) {
		this.commandes = commandes;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", commandes=" + commandes + "]";
	}	
}
