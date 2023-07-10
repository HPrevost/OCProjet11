package com.openclassrooms.p11api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.p11api.model.Etablissement;

@Repository
public interface EtablissementRepository extends CrudRepository<Etablissement, Long> {

}