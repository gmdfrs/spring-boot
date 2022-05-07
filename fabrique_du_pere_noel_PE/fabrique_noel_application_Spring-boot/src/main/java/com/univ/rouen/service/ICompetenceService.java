package com.univ.rouen.service;

import java.util.List;

import com.univ.rouen.entity.CompetenceEntity;

public interface ICompetenceService {

	public CompetenceEntity saveCompetence(CompetenceEntity competence);
	public CompetenceEntity updateCompetence(CompetenceEntity competence);
	public void deleteCompetence(Long competenceId);
	public CompetenceEntity findCompetenceById(Long competenceId);
	public List<CompetenceEntity> findAll();
	public boolean checkIfIdexists(Long id);
}
