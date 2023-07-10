package com.openclassrooms.p11api.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "occupation")
public class Occupation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idLit;

	private Long idPatient;

	private Date dateHeureDeb;

	private Date dateHeureFin;

	public Long getIdLit() {
		return idLit;
	}

	public void setIdLit(Long idLit2) {
		idLit = idLit2;
	}

	public Long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Long idPatient2) {
		idPatient = idPatient2;
	}

	public Date getDateHeureDeb() {
		return dateHeureDeb;
	}

	public void setDateHeureDeb(Date dateHeureDeb2) {
		dateHeureDeb = dateHeureDeb2;
	}

	public Date getDateHeureFin() {
		return dateHeureFin;
	}

	public void setDateHeureFin(Date dateHeureFin2) {
		dateHeureFin = dateHeureFin2;
	}

}
