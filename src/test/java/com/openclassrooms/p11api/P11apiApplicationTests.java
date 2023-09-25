package com.openclassrooms.p11api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.p11api.service.PatientService;

import io.micrometer.common.util.StringUtils;

@SpringBootTest
class P11apiApplicationTests {

	@Autowired
	private PatientService ps;

	@Test
	void contextLoads() {
	}

	@Test
	public void testfindLit() {

		// **************************
		// CAS 1 Sélection du lit le plus proche pour une spécialité donnée
		// Specialité = 2, position GPS = 20
		// {
		// "nomEtab": "La Timone",
		// "coordGPS": 28,
		// "refLitEtab": "Lit 1.2"
		// }

		String nomEtabExpected = "La Timone";
		Long coordGPSExpected = (long) 28;
		String refLitEtabExpected = "Lit 1.2";

		String nomEtabResult = ps.findLit((long) 2, (long) 20).getNomEtab();
		assertEquals(nomEtabExpected, nomEtabResult);

		Long coordGPSResult = ps.findLit((long) 2, (long) 20).getCoordGPS();
		assertEquals(coordGPSExpected, coordGPSResult);

		String refLitEtabResult = ps.findLit((long) 2, (long) 20).getRefLitEtab();
		assertEquals(refLitEtabExpected, refLitEtabResult);

		String errorMessageResult = ps.findLit((long) 2, (long) 20).getErrorMessage();
		assertTrue(StringUtils.isBlank(errorMessageResult));

		// **************************
		// CAS 2 Sélection du lit le plus proche pour la même specialité et une position
		// GPS différente

		// Spécialité = 2, position GPS = 7 *************************
		// {
		// "nomEtab": "Clinique Beauregard",
		// "coordGPS": 5,
		// "refLitEtab": "Lit 3.2"
		// }

		nomEtabExpected = "Clinique Beauregard";
		// nomEtabExpected = "Hôpital Test";

		coordGPSExpected = (long) 5;
		refLitEtabExpected = "Lit 3.2";

		nomEtabResult = ps.findLit((long) 2, (long) 7).getNomEtab();
		assertEquals(nomEtabExpected, nomEtabResult);

		coordGPSResult = ps.findLit((long) 2, (long) 7).getCoordGPS();
		assertEquals(coordGPSExpected, coordGPSResult);

		refLitEtabResult = ps.findLit((long) 2, (long) 7).getRefLitEtab();
		assertEquals(refLitEtabExpected, refLitEtabResult);

		// **************************
		// CAS 3 Aucun enregistrement trouvé pour une spécialité non représentée dans le
		// jeu d'essai

		// Spécialité = 40, position GPS = 7 *************************

		// {
		// "nomEtab": null,
		// "coordGPS": null,
		// "refLitEtab": null,
		// "erroMessage" : "Aucun lit disponible pour cette spécialité."
		// }

		assertNull(ps.findLit((long) 40, (long) 7));

		// CAS 4 Paramètres d'entrée incorrects **************************

	}

}
