USE DATABASE giocatori;

-- Un indice è una struttura dati che migliora la velocità delle operazioni di ricerca su una tabella a spese di spazio aggiuntivo e di tempo per l'aggiornamento dei dati. Gli indici possono essere creati su una o più colonne di una tabella e possono essere unici (garantendo che i valori siano unici) o non unici (consentendo valori duplicati).

CREATE UNIQUE INDEX idx_sigla_squadra ON squadre(sigla_squadra);
CREATE INDEX idx_cognome ON giocatori(cognome);