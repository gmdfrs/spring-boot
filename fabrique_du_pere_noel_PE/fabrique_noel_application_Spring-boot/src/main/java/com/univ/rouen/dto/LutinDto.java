package com.univ.rouen.dto;

import java.util.List;

import com.univ.rouen.entity.CompetenceEntity;

/**
 * Dto lutin
 * @author GROUPE JEE
 */
public class LutinDto extends UserDto {
	// id 
	private Long id;
	// lutin disponible ou non 
	private boolean disposable;
	// la liste des competances
	private List<CompetenceEntity> lutinCompetences;
	
	public LutinDto() {}

	public LutinDto(Long id, boolean disposable, List<CompetenceEntity> lutinCompetences) {
		super();
		this.id = id;
		this.disposable = disposable;
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
		return "LutinDto [id=" + id + ", disposable=" + disposable + ", lutinCompetences=" + lutinCompetences + "]";
	}

	
	
	
}
