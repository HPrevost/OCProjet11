package com.openclassrooms.p11api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "lit")
public class Lit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String refLitEtab;

	private Long idEtablissement;

	private Long idSpecialite;

	public String getRefLitEtab() {
		return refLitEtab;
	}

	public void setRefLitEtab(String refLitEtab2) {
		refLitEtab = refLitEtab2;
	}

	public Long getIdEtablissement() {
		return idEtablissement;
	}

	public void setIdEtablissement(Long idEtablissement2) {
		idEtablissement = idEtablissement2;

	}

	public Long getIdSpecialite() {
		return idSpecialite;
	}

	public void setSpecialite(Long idSpecialite2) {
		idSpecialite = idSpecialite2;

	}

}
