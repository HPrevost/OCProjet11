package com.openclassrooms.p11api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.p11api.service.FindLitResult;
import com.openclassrooms.p11api.service.PatientService;

@CrossOrigin
@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	// @RequestMapping(value = "patient/urgence", method = RequestMethod.POST,
	// headers = {
	// "Access-Control-Allow-Origin=http://localhost:8080" })
	// "Access-Control-Allow-Headers=Content-Type, Authorization",
	// "Access-Control-Allow-Methods=POST",

	// @GetMapping("patient/urgence")
	@CrossOrigin
	@PostMapping(value = "patient/urgence")
	// , headers = {
	// "Access-Control-Allow-Origin=*",
	// "Access-Control-Allow-Headers=Content-Type, Authorization" })
	// "Access-Control-Allow-Methods=POST" })
	// , headers = { "Access-Control-Allow-Origin=http://127.0.0.1:3000" },
	// }
	// http://127.0.0.1:3000/
	/// -------

	public FindLitResult findLit(@RequestParam(required = true) Long specialiteId,
			@RequestParam(required = true) Long gpsPosition,
			@RequestParam(defaultValue = "false", required = false, value = "return") Boolean ret) {
		return patientService.findLit(specialiteId, gpsPosition);

	}

}
