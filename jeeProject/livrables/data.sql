drop table session;
drop table epreuve;
drop table discipline;
drop table site;
-- Création de la table discipline avec id en auto-incrément
CREATE TABLE discipline (
    id INT AUTO_INCREMENT PRIMARY KEY,
    est_paralympique BOOLEAN,
    nom VARCHAR(255)
);

-- Insertion des disciplines
INSERT INTO discipline (est_paralympique, nom) VALUES (false, 'Athlétisme');
INSERT INTO discipline (est_paralympique, nom) VALUES (false, 'Judo');
INSERT INTO discipline (est_paralympique, nom) VALUES (false, 'Basketball');
INSERT INTO discipline (est_paralympique, nom) VALUES (false, 'Badmington');
INSERT INTO discipline (est_paralympique, nom) VALUES (false, 'Natation');
INSERT INTO discipline (est_paralympique, nom) VALUES (false, 'Escrime');
INSERT INTO discipline (est_paralympique, nom) VALUES (false, 'Tir à l’arc Individuel');
INSERT INTO discipline (est_paralympique, nom) VALUES (false, 'Boxe');
INSERT INTO discipline (est_paralympique, nom) VALUES (false, 'Gymnastique artistique');
INSERT INTO discipline (est_paralympique, nom) VALUES (false, 'Tennis');
INSERT INTO discipline (est_paralympique, nom) VALUES (false, 'Trampoline');
INSERT INTO discipline (est_paralympique, nom) VALUES (false, 'Waterpolo');

-- Création de la table epreuve avec une clé étrangère discipline_id
CREATE TABLE epreuve (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255),
    discipline_id INT,
    FOREIGN KEY (discipline_id) REFERENCES discipline(id)
);

-- Insertion des épreuves pour Athlétisme
INSERT INTO epreuve (nom, discipline_id) VALUES ('100m', (SELECT id FROM discipline WHERE nom = 'Athlétisme'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('110m haies', (SELECT id FROM discipline WHERE nom = 'Athlétisme'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('3000m steeple', (SELECT id FROM discipline WHERE nom = 'Athlétisme'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('Relais 4x100m', (SELECT id FROM discipline WHERE nom = 'Athlétisme'));

-- Insertion des épreuves pour Judo
INSERT INTO epreuve (nom, discipline_id) VALUES ('-48 kg', (SELECT id FROM discipline WHERE nom = 'Judo'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('-57kg', (SELECT id FROM discipline WHERE nom = 'Judo'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('-66kg', (SELECT id FROM discipline WHERE nom = 'Judo'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('-81kg', (SELECT id FROM discipline WHERE nom = 'Judo'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('-100kg', (SELECT id FROM discipline WHERE nom = 'Judo'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('+100kg', (SELECT id FROM discipline WHERE nom = 'Judo'));

-- Insertion des épreuves pour Basketball
INSERT INTO epreuve (nom, discipline_id) VALUES ('Tournoi à 12 équipes', (SELECT id FROM discipline WHERE nom = 'Basketball'));

-- Insertion des épreuves pour Badmington
INSERT INTO epreuve (nom, discipline_id) VALUES ('Tournoi simple', (SELECT id FROM discipline WHERE nom = 'Badmington'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('Tournoi double', (SELECT id FROM discipline WHERE nom = 'Badmington'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('Tournoi double mixte', (SELECT id FROM discipline WHERE nom = 'Badmington'));

-- Insertion des épreuves pour Natation
INSERT INTO epreuve (nom, discipline_id) VALUES ('50m nage libre', (SELECT id FROM discipline WHERE nom = 'Natation'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('100m dos', (SELECT id FROM discipline WHERE nom = 'Natation'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('200m brasse', (SELECT id FROM discipline WHERE nom = 'Natation'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('Relais 4x100m nage libre', (SELECT id FROM discipline WHERE nom = 'Natation'));

-- Insertion des épreuves pour Escrime
INSERT INTO epreuve (nom, discipline_id) VALUES ('Epée individuelle', (SELECT id FROM discipline WHERE nom = 'Escrime'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('Epée par équipe', (SELECT id FROM discipline WHERE nom = 'Escrime'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('Sabre individuel', (SELECT id FROM discipline WHERE nom = 'Escrime'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('Sabre par équipe', (SELECT id FROM discipline WHERE nom = 'Escrime'));

-- Insertion des épreuves pour Tir à l’arc
INSERT INTO epreuve (nom, discipline_id) VALUES ('Tir à l’arc individuel', (SELECT id FROM discipline WHERE nom = 'Tir à l’arc Individuel'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('Tir à l’arc par équipe', (SELECT id FROM discipline WHERE nom = 'Tir à l’arc Individuel'));

-- Insertion des épreuves pour Boxe
INSERT INTO epreuve (nom, discipline_id) VALUES ('69kg', (SELECT id FROM discipline WHERE nom = 'Boxe'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('75kg', (SELECT id FROM discipline WHERE nom = 'Boxe'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('91kg', (SELECT id FROM discipline WHERE nom = 'Boxe'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('+91kg', (SELECT id FROM discipline WHERE nom = 'Boxe'));

-- Insertion des épreuves pour Gymnastique artistique
INSERT INTO epreuve (nom, discipline_id) VALUES ('Poutre', (SELECT id FROM discipline WHERE nom = 'Gymnastique artistique'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('Anneaux', (SELECT id FROM discipline WHERE nom = 'Gymnastique artistique'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('Barres asymétriques', (SELECT id FROM discipline WHERE nom = 'Gymnastique artistique'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('Barre fixe', (SELECT id FROM discipline WHERE nom = 'Gymnastique artistique'));

-- Insertion des épreuves pour Tennis
INSERT INTO epreuve (nom, discipline_id) VALUES ('Tournoi simple', (SELECT id FROM discipline WHERE nom = 'Tennis'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('Tournoi double', (SELECT id FROM discipline WHERE nom = 'Tennis'));
INSERT INTO epreuve (nom, discipline_id) VALUES ('Tournoi double mixte', (SELECT id FROM discipline WHERE nom = 'Tennis'));

-- Insertion des épreuves pour Trampoline
INSERT INTO epreuve (nom, discipline_id) VALUES ('Trampoline individuel', (SELECT id FROM discipline WHERE nom = 'Trampoline'));

-- Insertion des épreuves pour Waterpolo
INSERT INTO epreuve (nom, discipline_id) VALUES ('Tournoi', (SELECT id FROM discipline WHERE nom = 'Waterpolo'));



CREATE TABLE site (
    id INT AUTO_INCREMENT PRIMARY KEY,
    categorie INT,
    nom VARCHAR(255),
    ville VARCHAR(255));

INSERT INTO site (categorie, nom, ville) VALUES (0, 'Stade de France', 'Saint-Denis');
INSERT INTO site (categorie, nom, ville) VALUES (0, 'Allianz Riviera', 'Nice');
INSERT INTO site (categorie, nom, ville) VALUES (0, 'Parc des Princes', 'Paris');
INSERT INTO site (categorie, nom, ville) VALUES (0, 'Stade Vélodrome', 'Marseille');
INSERT INTO site (categorie, nom, ville) VALUES (0, 'Matmut Atlantique', 'Bordeaux');

-- 5 salles de spectacle
INSERT INTO site (categorie, nom, ville) VALUES (1, 'AccorHotels Arena', 'Paris');
INSERT INTO site (categorie, nom, ville) VALUES (1, 'Zénith de Paris', 'Paris');
INSERT INTO site (categorie, nom, ville) VALUES (1, 'Le Zénith Sud', 'Montpellier');
INSERT INTO site (categorie, nom, ville) VALUES (1, 'Le Dôme', 'Marseille');
INSERT INTO site (categorie, nom, ville) VALUES (1, 'Zénith de Nantes Métropole', 'Nantes');

-- 5 lieux publics
INSERT INTO site (categorie, nom, ville) VALUES (2, 'Grand Place', 'Lille');
INSERT INTO site (categorie, nom, ville) VALUES (2, 'Place Stanislas', 'Nancy');
INSERT INTO site (categorie, nom, ville) VALUES (2, 'Place Bellecour', 'Lyon');
INSERT INTO site (categorie, nom, ville) VALUES (2, 'Place du Capitole', 'Toulouse');
INSERT INTO site (categorie, nom, ville) VALUES (2, 'Place de la Comédie', 'Montpellier');

-- 5 centres aquatiques
INSERT INTO site (categorie, nom, ville) VALUES (3, 'Piscine Olympique', 'Montreal');
INSERT INTO site (categorie, nom, ville) VALUES (3, 'Aquaboulevard', 'Paris');
INSERT INTO site (categorie, nom, ville) VALUES (3, 'Aquapolis', 'Limoges');
INSERT INTO site (categorie, nom, ville) VALUES (3, 'Centre Aquatique du Lac', 'Bordeaux');
INSERT INTO site (categorie, nom, ville) VALUES (3, 'Piscine de la Confluence', 'Lyon');


-- Insertion de données fictives pour la table session
-- Création de la table session
CREATE TABLE session (
    id INT AUTO_INCREMENT PRIMARY KEY,
    code_session VARCHAR(5),
    date DATE,
    description VARCHAR(255),
    heure_debut TIME,
    heure_fin TIME,
    type_session VARCHAR(255),
    discipline_id INT,
    site_competition_id INT,
    epreuve_id INT,
    CONSTRAINT fk_discipline FOREIGN KEY (discipline_id) REFERENCES discipline(id),
    CONSTRAINT fk_site FOREIGN KEY (site_competition_id) REFERENCES site(id),
    CONSTRAINT fk_epreuve FOREIGN KEY (epreuve_id) REFERENCES epreuve(id),
    CONSTRAINT uc_code_session UNIQUE (code_session)
);

-- Création de la table session
CREATE TABLE session (
    id INT AUTO_INCREMENT PRIMARY KEY,
    code_session VARCHAR(5),
    date DATE,
    description VARCHAR(255),
    heure_debut TIME,
    heure_fin TIME,
    type_session VARCHAR(255),
    discipline_id INT,
    site_competition_id INT,
    epreuve_id INT,
    CONSTRAINT fk_discipline FOREIGN KEY (discipline_id) REFERENCES discipline(id),
    CONSTRAINT fk_site FOREIGN KEY (site_competition_id) REFERENCES site(id),
    CONSTRAINT fk_epreuve FOREIGN KEY (epreuve_id) REFERENCES epreuve(id),
    CONSTRAINT uc_code_session UNIQUE (code_session)
);

-- Insertion de données fictives pour la table session
INSERT INTO session (code_session, date, description, heure_debut, heure_fin, type_session, discipline_id, site_competition_id, epreuve_id)
VALUES
    ('ATH01', '2024-07-26', 'Athlétisme Session 1', '08:00:00', '12:00:00', 'Qualifications', 1, 1, 1),
    ('JUD01', '2024-07-26', 'Judo Session 1', '09:00:00', '13:00:00', 'Qualifications', 2, 2, 5),
    ('BAS01', '2024-07-26', 'Basketball Session 1', '10:00:00', '14:00:00', 'Médailles', 3, 3, 11),
    -- Ajoutez d'autres sessions fictives en respectant les contraintes...
    ('ESC01', '2024-07-27', 'Escrime Session 1', '14:00:00', '18:00:00', 'Qualifications', 6, 1, 19),
    ('TIR01', '2024-07-27', 'Tir à l’arc Session 1', '15:00:00', '19:00:00', 'Médailles', 7, 2, 23),
    ('BOX01', '2024-07-27', 'Boxe Session 1', '16:00:00', '20:00:00', 'Qualifications', 8, 3, 25),
    ('GYM01', '2024-07-28', 'Gymnastique Session 1', '08:00:00', '12:00:00', 'Médailles', 9, 4, 30),
    -- Continuez d'ajouter des sessions fictives...
    -- Ajoutez d'autres sessions fictives en respectant les contraintes...
    ('ESC02', '2024-07-31', 'Escrime Session 2', '14:00:00', '18:00:00', 'Qualifications', 6, 1, 21),
    ('TIR02', '2024-07-31', 'Tir à l’arc Session 2', '15:00:00', '19:00:00', 'Médailles', 7, 2, 27),
    ('BOX02', '2024-07-31', 'Boxe Session 2', '16:00:00', '20:00:00', 'Qualifications', 8, 3, 28),
    ('GYM02', '2024-08-01', 'Gymnastique Session 2', '08:00:00', '12:00:00', 'Médailles', 9, 4, 32),
    -- Continuez d'ajouter des sessions fictives...
    ('TEN02', '2024-08-02', 'Tennis Session 2', '10:00:00', '14:00:00', 'Médailles', 10, 1, 33),
    ('TRA02', '2024-08-02', 'Trampoline Session 2', '11:00:00', '15:00:00', 'Qualifications', 11, 2, 36),
    ('WAT02', '2024-08-02', 'Waterpolo Session 2', '12:00:00', '16:00:00', 'Médailles', 12, 3, 37),
    -- Continue with additional sessions...
    -- Ajoutez d'autres sessions fictives en respectant les contraintes...
    ('ESC03', '2024-08-04', 'Escrime Session 3', '14:00:00', '18:00:00', 'Qualifications', 6, 1, 19),
    ('TIR03', '2024-08-04', 'Tir à l’arc Session 3', '15:00:00', '19:00:00', 'Médailles', 7, 2, 23),
    ('BOX03', '2024-08-04', 'Boxe Session 3', '16:00:00', '20:00:00', 'Qualifications', 8, 3, 25),
    ('GYM03', '2024-08-05', 'Gymnastique Session 3', '08:00:00', '12:00:00', 'Médailles', 9, 4, 30);
