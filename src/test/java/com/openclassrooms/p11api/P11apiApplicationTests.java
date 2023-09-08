package com.openclassrooms.p11api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.p11api.service.PatientService;

@SpringBootTest
class P11apiApplicationTests {

	@Autowired
	private PatientService ps;

	@Test
	void contextLoads() {
	}

	@Test
	public void testfindLit() {

		// Specialité = 2, pos GPS =20 **************************
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

		// Specialité = 2, pos GPS =7 *************************
		// {
		// "nomEtab": "Clinique Beauregard",
		// "coordGPS": 5,
		// "refLitEtab": "Lit 3.2"
		// }
		nomEtabExpected = "Clinique Beauregard";
		coordGPSExpected = (long) 5;
		refLitEtabExpected = "Lit 3.2";

		nomEtabResult = ps.findLit((long) 2, (long) 7).getNomEtab();
		assertEquals(nomEtabExpected, nomEtabResult);

		coordGPSResult = ps.findLit((long) 2, (long) 7).getCoordGPS();
		assertEquals(coordGPSExpected, coordGPSResult);

		refLitEtabResult = ps.findLit((long) 2, (long) 7).getRefLitEtab();
		assertEquals(refLitEtabExpected, refLitEtabResult);
	}

}
