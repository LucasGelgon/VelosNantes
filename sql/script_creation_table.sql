
/**
SCRIPT de création de tables à partir du diagramme de classe réalisé*/
DROP TABLE Comptage;
DROP TABLE TypeVelo;
DROP TABLE Journee;
DROP TABLE Compteur;
DROP TABLE Quartier;


CREATE TABLE Quartier(
    idQuartier NUMBER
        CONSTRAINT pk_Quartier PRIMARY KEY,
    nomQuartier VARCHAR2(60),
    longueurPiste NUMBER
);


CREATE TABLE Compteur(
    idCompteur NUMBER
        CONSTRAINT pk_Compteur PRIMARY KEY,
    longitude NUMBER,
    latitude NUMBER,
    observations VARCHAR2(30),
    leQuartier NUMBER
        CONSTRAINT fk_Compteur_Quartier REFERENCES Quartier(idQuartier)
);


CREATE TABLE Journee(
    jour DATE
        CONSTRAINT pk_Journee PRIMARY KEY,
    jourSemaine NUMBER
        CONSTRAINT ck_domaineJourSemaine CHECK (jourSemaine BETWEEN 1 AND 7 ),
    vacancesZoneB VARCHAR2(30),
    tMoy NUMBER
);

CREATE TABLE TypeVelo(
	
	idTypeVelo NUMBER
		CONSTRAINT pk_idTypeVelo PRIMARY KEY,
	
	nomTypeVelo VARCHAR2(20),
		
	marque VARCHAR2(20)
	
);

CREATE TABLE Comptage(
    leJour DATE
        CONSTRAINT fk_Comptage_Journee REFERENCES Journee(jour)
        CONSTRAINT nn_leJour NOT NULL,
    h0 NUMBER,
    h1 NUMBER,
    h2 NUMBER,
    h3 NUMBER,
    h4 NUMBER,
    h5 NUMBER,
    h6 NUMBER,
    h7 NUMBER,
    h8 NUMBER,
    h9 NUMBER,
    h10 NUMBER,
    h11 NUMBER,
    h12 NUMBER,
    h13 NUMBER,
    h14 NUMBER,
    h15 NUMBER,
    h16 NUMBER,
    h17 NUMBER,
    h18 NUMBER,
    h19 NUMBER,
    h20 NUMBER,
    h21 NUMBER,
    h22 NUMBER,
    h23 NUMBER,
    probaAnomalie VARCHAR2(30)
        CONSTRAINT ck_domaineProbaAnomalie CHECK (probaAnomalie IN (UPPER('FORTE'), UPPER('FAIBLE'))),
    boucleNum NUMBER
        CONSTRAINT fk_Comptage_Compteur REFERENCES Compteur(idCompteur)
        CONSTRAINT nn_boucleNum NOT NULL,    
    leTypeVelo NUMBER
		CONSTRAINT fk_leTypeVelo REFERENCES TypeVelo(idTypeVelo),

    CONSTRAINT pk_Comptage PRIMARY KEY (leJour, boucleNum)
);


INSERT INTO TypeVelo
VALUES(1, 'VTT', 'Giant');
INSERT INTO TypeVelo
VALUES(2, 'Vélo de ville', null);
INSERT INTO TypeVelo
VALUES(3, 'Tandem', 'Scott');
INSERT INTO TypeVelo
VALUES(4, 'Vélo de route', 'Trek');
INSERT INTO TypeVelo
VALUES(5, 'VTT', 'Canyon');
INSERT INTO TypeVelo
VALUES(6, 'Vélo de ville', 'Scott');



