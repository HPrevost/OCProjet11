package com.openclassrooms.p11api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.p11api.model.Etablissement;
import com.openclassrooms.p11api.service.EtablissementService;

@RestController
public class EtablissementController {

	@Autowired
	private EtablissementService etablissementService;

	/**
	 * Create - Add a new etablissement
	 * 
	 * @param etablissement An object etablissement
	 * @return The etablissement object saved
	 */
	@PostMapping("/etablissement")
	public Etablissement createEtablissement(@RequestBody Etablissement etablissement) {
		return etablissementService.saveEtablissement(etablissement);
	}

	/**
	 * Read - Get one etablissement
	 * 
	 * @param id The id of the etablissement
	 * @return An Etablissement object full filled
	 */
	@GetMapping("/etablissement/{id}")
	public Etablissement getEtablissement(@PathVariable("id") final Long id) {
		Optional<Etablissement> etablissement = etablissementService.getEtablissement(id);
		if (etablissement.isPresent()) {
			return etablissement.get();
		} else {
			return null;
		}
	}

	/**
	 * Read - Get all etablissements
	 * 
	 * @return - An Iterable object of Etablissement full filled
	 */
	@GetMapping("/etablissements")
	public Iterable<Etablissement> getEtablissements() {
		return etablissementService.getEtablissements();
	}

	/**
	 * Update - Update an existing etablissement
	 * 
	 * @param id       - The id of the etablissement to update
	 * @param employee - The etablissement object updated
	 * @return
	 */
	@PutMapping("/etablissement/{id}")
	public Etablissement updateEtablissement(@PathVariable("id") final Long id,
			@RequestBody Etablissement etablissement) {

		Optional<Etablissement> e = etablissementService.getEtablissement(id);

		if (e.isPresent()) {

			Etablissement currentEtablissement = e.get();

			String nomEtab = etablissement.getNomEtab();
			if (nomEtab != null && nomEtab != "") {
				currentEtablissement.setNomEtab(nomEtab);
			}
			String adrEtab = etablissement.getAdrEtab();
			if (adrEtab != null) {
				currentEtablissement.setAdrEtab(adrEtab);
			}
			String coordGPSEtab = etablissement.getCoordGPSEtab();
			if (coordGPSEtab != null) {
				currentEtablissement.setCoordGPSEtab(coordGPSEtab);
			}

			etablissementService.saveEtablissement(currentEtablissement);

			return currentEtablissement;

		} else {
			return null;
		}
	}

	/**
	 * Delete - Delete an employee
	 * 
	 * @param id - The id of the employee to delete
	 */
	@DeleteMapping("/etablissement/{id}")
	public void deleteEtablissement(@PathVariable("id") final Long id) {
		etablissementService.deleteEtablissement(id);
	}

}