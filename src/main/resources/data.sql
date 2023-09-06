/*etablissement**************************************/

DROP TABLE IF EXISTS etablissement;
 
CREATE TABLE etablissement (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nom_etab VARCHAR(255) NOT NULL,
  adr_etab VARCHAR(255) NOT NULL,
  coordgpsetab VARCHAR(250) NOT NULL
);
 
INSERT INTO etablissement (nom_etab, adr_etab, coordgpsetab ) VALUES
  ('La Timone', '3, rue des chats - 13000 MARSEILLE', '28'), 
    ('La Salpétrière', '2, place des Alouettes - 75000 PARIS', '10'),
  ('Clinique Beauregard', '10, Avenue des armées - 69000 LYON', '5');


/*groupe_specia**************************************/

DROP TABLE IF EXISTS groupe_specia;
 
CREATE TABLE groupe_specia (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nom_groupe_specia VARCHAR(255) NOT NULL
);

INSERT INTO groupe_specia (nom_groupe_specia ) VALUES

  ('Médecine générale'),
  ('Pathologie');


/*Specialité**************************************/

DROP TABLE IF EXISTS specialite;

CREATE TABLE specialite (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nom_specia VARCHAR(255) NOT NULL,
  id_groupe_specia INT NOT NULL
);

INSERT INTO specialite (nom_specia,id_groupe_specia) VALUES

  ('Cardiologie',1),
  ('Neurologie',1),
  ('Immunologie',2);


/*Lit**************************************/

DROP TABLE IF EXISTS lit;

CREATE TABLE lit (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_etablissement INT NOT NULL,
  id_specialite INT NOT NULL,
  ref_lit_etab VARCHAR(255) NOT NULL
);

INSERT INTO lit (ref_lit_etab, id_etablissement,id_specialite ) VALUES

  ('Lit 1.1',1,1),
  ('Lit 1.2',1,2),
  ('Lit 1.3',1,3),

  ('Lit 2.1',2,1),
  ('Lit 2.2',2,2),
  ('Lit 2.3',2,3),

  ('Lit 3.1',3,1),
  ('Lit 3.2',3,2),
  ('Lit 3.3',3,3);

/*patient**************************************/

DROP TABLE IF EXISTS patient;
 
CREATE TABLE patient (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nom_patient VARCHAR(255) NOT NULL,
  adr_patient VARCHAR(255) NOT NULL,
  nosspatient VARCHAR(255) NOT NULL
);
 
INSERT INTO patient (nom_patient,adr_patient,nosspatient) VALUES

  ('Dupond Jean', '3, rue des oliviers - 13000 MARSEILLE', '163069932611904'),
  ('Durand Paul', '2, place des palmiers - 75000 PARIS', '263069932611907'),
  ('Martin Jacques', '10, Avenue des cerisiers - 69000 LYON', '183061832611909');

/*occupation*****************************************/


DROP TABLE IF EXISTS occupation;

CREATE TABLE occupation (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_lit INT NOT NULL,
  id_patient INT NOT NULL,
  date_heure_deb TIMESTAMP NOT NULL,
date_heure_fin TIMESTAMP NOT NULL
);

INSERT INTO occupation (id_lit, id_patient, date_heure_deb, date_heure_fin) VALUES

  (1,1,'2023-07-12 00:00:00','2023-09-05 00:00:00'),
  (2,2,'2023-07-12 00:00:00','2023-09-05 00:00:00'),
  (3,3,'2023-07-12 00:00:00','2023-09-05 00:00:00'),

  (4,1,'2023-08-12 00:00:00','2023-09-05 00:00:00'),
  (5,2,'2023-08-12 00:00:00','2023-09-05 00:00:00'),
  (6,3,'2023-08-12 00:00:00','2023-09-05 00:00:00'),

  (7,1,'2023-08-12 00:00:00','2023-09-05 00:00:00'),
  (8,2,'2023-08-12 00:00:00','2023-09-05 00:00:00'),
  (9,3,'2023-08-12 00:00:00','2023-09-05 00:00:00');
