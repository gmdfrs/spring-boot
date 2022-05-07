package com.univ.rouen.entity;

import java.util.List;
import javax.persistence.*;

/**
 * Entity lutin
 * @author GROUPE JEE
 */
@Entity
@DiscriminatorValue("lutin")
public class LutinEntity extends UserEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean disposable;
	
	@ManyToMany
	private List<CompetenceEntity> lutinCompetences;
	@ManyToOne
	private CommandeEntity commande;
	

	public LutinEntity() {}

	public LutinEntity(Long id, boolean disposable, List<CompetenceEntity>lutinCompetences, CommandeEntity commande) {
		
		super();
		this.id = id;
		this.disposable = disposable;
		this.commande = commande;
		this.lutinCompetences = lutinCompetences;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isDisposable() {
		return disposable;
	}

	public void setDisposable(boolean disposable) {
		this.disposable = disposable;
	}
	
	public List<CompetenceEntity> getLutinCompetences() {
		return lutinCompetences;
	}

	public void setLutinCompetences(List<CompetenceEntity> lutinCompetences) {
		this.lutinCompetences = lutinCompetences;
	}


	@Override
	public String toString() {
		return "LutinEntity [id=" + id + ", disposable=" + disposable + ", lutinCompetences=" + lutinCompetences + "]";
	}

	
	

}
