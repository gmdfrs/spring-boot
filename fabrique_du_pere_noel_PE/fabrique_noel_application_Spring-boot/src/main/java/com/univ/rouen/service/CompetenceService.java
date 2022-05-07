package com.univ.rouen.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univ.rouen.entity.CompetenceEntity;
import com.univ.rouen.repository.CompetenceRepository;

/**
 * Service pour competence
 * @author GROUPE JEE
 */
@Service
public class CompetenceService implements ICompetenceService {
	@Autowired
	private CompetenceRepository competenceRepository;
	@Override
	public CompetenceEntity saveCompetence(CompetenceEntity competence) {
		
		return	competenceRepository.save(competence);
	}

	@Override
	public CompetenceEntity updateCompetence(CompetenceEntity competence) {
		
		return competenceRepository.save(competence);
	}

	@Override
	public void deleteCompetence(Long competenceId) {
		competenceRepository.deleteById(competenceId);

	}

	@Override
	public CompetenceEntity findCompetenceById(Long competenceId) {
		
		return competenceRepository.findById(competenceId).orElse(new CompetenceEntity());
	}

	@Override
	public boolean checkIfIdexists(Long id) {
		// TODO Auto-generated method stub
		return competenceRepository.existsById(id);
	}

	@Override
	public List<CompetenceEntity> findAll() {
		
		return competenceRepository.findAll();
	}

}
