package com.openclassrooms.p11api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomPatient;

	private String adrPatient;

	private String noSSPatient;
	
	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient2) {
		nomPatient = nomPatient2;
	}

	public String getAdrPatient() {
		return adrPatient;
	}

	public void setAdrPatient(String adrPatient2) {
		adrPatient = adrPatient2;

	}

	public String getNoSSPatient() {
		return noSSPatient;
	}

	public void setNoSSPatient(String noSSPatient2) {
		noSSPatient = noSSPatient2;
	}

}
