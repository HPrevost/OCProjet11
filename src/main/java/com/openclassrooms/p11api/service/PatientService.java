package com.openclassrooms.p11api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.p11api.repository.PatientRepository;

import lombok.Data;

@Data
@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public FindLitResult findLit(Long specialiteId, Long gpsPosition) {

		return patientRepository.findLit(specialiteId, gpsPosition);
	}

}