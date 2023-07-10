package com.openclassrooms.p11api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "groupe_specia")
public class GroupeSpecia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomGroupeSpecia;

	public String getNomGroupeSpecia() {
		return nomGroupeSpecia;
	}

	public void setNomGroupeSpecia(String nomGroupeSpecia2) {
		nomGroupeSpecia = nomGroupeSpecia2;
	}

}
