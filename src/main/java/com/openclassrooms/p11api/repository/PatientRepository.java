package com.openclassrooms.p11api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.openclassrooms.p11api.model.Patient;
import com.openclassrooms.p11api.service.FindLitResult;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	/*
	 * @Query(value =
	 * "select lit.ref_lit_etab as refLit,etablissement.nom_etab as nomEtab,etablissement.coordgpsetab as coordGPS"
	 * +
	 * " from lit inner join etablissement on lit.id_etablissement=etablissement.id"
	 * +
	 * " left join (select id_lit from occupation where curdate()>=date_heure_deb and curdate()<=date_heure_fin) a on lit.id=a.id_lit"
	 * + " where lit.id_specialite=?1 and a.id_lit is null" +
	 * " order by coordgpsetab-?2 limit 1;", nativeQuery = true)
	 */
	@Query(value = "select lit.ref_lit_etab as refLitEtab,etablissement.nom_etab as nomEtab,etablissement.coordgpsetab as coordGPS"
			+ " from lit inner join etablissement on lit.id_etablissement=etablissement.id"
			+ " where lit.id_specialite=ifnull(?1,0) order by abs(etablissement.coordgpsetab-ifnull(?2,0)) limit 1;", nativeQuery = true)

	// Long patientId,
	FindLitResult findLit(Long specialiteId, Long gpsPosition);
}