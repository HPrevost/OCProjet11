package com.openclassrooms.p11api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "specialite")
public class Specialite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomSpecia;

	private Long idGroupeSpecia;

	public String getNomSpecia() {
		return nomSpecia;
	}

	public void setNomEtab(String nomSpecia2) {
		nomSpecia = nomSpecia2;
	}

	public Long getIdGroupeSpecia() {
		return idGroupeSpecia;
	}

	public void setIdGroupeSpecia(Long idGroupeSpecia2) {
		idGroupeSpecia = idGroupeSpecia2;

	}

}
