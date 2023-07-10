package com.openclassrooms.p11api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "etablissement")
public class Etablissement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomEtab;

	private String adrEtab;

	private String coordGPSEtab;

	public String getNomEtab() {
		return nomEtab;
	}

	public void setNomEtab(String nomEtab2) {
		nomEtab = nomEtab2;
	}

	public String getAdrEtab() {
		return adrEtab;
	}

	public void setAdrEtab(String adrEtab2) {
		adrEtab = adrEtab2;

	}

	public String getCoordGPSEtab() {
		return coordGPSEtab;
	}

	public void setCoordGPSEtab(String coordGPSEtab2) {
		coordGPSEtab = coordGPSEtab2;
	}

}
