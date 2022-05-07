package com.univ.rouen.dto;

import java.util.List;

import javax.persistence.OneToMany;

import com.univ.rouen.entity.JouetEntity;

/**
 * Dto competence
 * @author GROUPE JEE
 */
public class CompetenceDto {

	private String nom;
	private List<JouetEntity> jouets;
}
