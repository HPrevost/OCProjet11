package com.openclassrooms.p11api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.p11api.service.FindLitResult;
import com.openclassrooms.p11api.service.PatientService;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	private class ErrorMessage implements FindLitResult {

		@Override
		public String getRefLitEtab() {

			return null;
		}

		@Override
		public String getNomEtab() {

			return null;
		}

		@Override
		public Long getCoordGPS() {

			return null;
		}

		@Override
		public String getErrorMessage() {

			return "Aucun lit disponible pour cette spécialité.";
		}

	}

	@CrossOrigin
	@PostMapping(value = "patient/urgence")

	public FindLitResult findLit(@RequestParam(required = true) Long specialiteId,
			@RequestParam(required = true) Long gpsPosition, HttpServletResponse response) throws IOException {

		FindLitResult test = patientService.findLit(specialiteId, gpsPosition);
		if (test == null) {
			response.setStatus(202);

			return new ErrorMessage();
		}
		return test;

	}

}
