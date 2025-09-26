INSERT INTO squadre
VALUES (1, 'INT', 'Internazionale', 'Milano', 'Italia');

INSERT INTO squadre
VALUES (2, 'JUV', 'Juventus', 'Torino', 'Italia');

INSERT INTO squadre
VALUES (3, 'MUN', 'Manchester United', 'Manchester', 'Inghilterra'),
       (4, 'MCI', 'Manchester City', 'Manchester', 'Inghilterra'),
       (5, 'ALN', 'Al Nassr', 'Riad', 'Arabia Saudita'),
       (6, 'PSG', 'Paris Saint-Germain', 'Parigi', 'Francia'),
       (7, 'RMA', 'Real Madrid', 'Madrid', 'Spagna'),
       (8, 'BAR', 'Barcellona', 'Barcellona', 'Spagna'),
       (9, 'NAP', 'Napoli', 'Napoli', 'Italia');

INSERT INTO giocatori
VALUES (1, 'Lautaro', 'Martinez', NULL, NULL, TRUE, '1997-08-22', NULL, NULL, NULL, 1),
       (2, 'Cristiano', 'Ronaldo', NULL, NULL, TRUE, '1985-02-05', NULL, NULL, NULL, 5),
       (3, 'Kevin', 'De Bruyne', NULL, NULL, TRUE, '1991-06-28', NULL, NULL, NULL, 9);

INSERT INTO squadre (sigla_squadra, nome, citta, nazione)
VALUES ('MIL', 'Milan', 'Milano', 'Italia');

INSERT INTO giocatori (nome, cognome, attivo, data_nascita, id_squadra)
VALUES ('Luka', 'Modric', TRUE, '1985-09-09', 10);