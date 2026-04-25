-- I trigger sono procedure che vengono eseguite automaticamente in risposta a determinati eventi su una tabella o vista. Possono essere utilizzati per mantenere l'integrità dei dati, eseguire controlli di sicurezza (ad esempio con tabelle di audit), o automatizzare processi.

CREATE TABLE Audit_ordini (
    id INT AUTO_INCREMENT PRIMARY KEY,
    azione VARCHAR(255),
    id_ordine INT,
    data_azione TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Audit_clienti (
    id INT AUTO_INCREMENT PRIMARY KEY,
    azione VARCHAR(255),
    id_cliente INT,
    data_azione TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Audit_prodotti (
    id INT AUTO_INCREMENT PRIMARY KEY,
    azione VARCHAR(255),
    id_prodotto INT,
    data_azione TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Creazione di un trigger che si attiva dopo l'inserimento di un nuovo record nella tabella "Ordini"

-- AFTER indica che il trigger si attiva dopo l'inserimento di un nuovo record. BEFORE indicherebbe che il trigger si attiva prima dell'inserimento.
-- INSERT è l'evento che attiva il trigger. Può essere anche UPDATE o DELETE.
-- FOR EACH ROW specifica che il trigger si applica a ogni riga inserita. FOR EACH STATEMENT indicherebbe che il trigger si applica una sola volta per l'intera operazione, indipendentemente dal numero di righe coinvolte.
-- NEW è una parola chiave che si riferisce al nuovo record inserito. OLD si riferirebbe al record prima dell'aggiornamento o eliminazione.
-- DELIMITER // serve per cambiare il delimitatore di fine istruzione, in modo da poter utilizzare il punto e virgola all'interno del corpo del trigger senza terminare l'istruzione CREATE TRIGGER.

DELIMITER //
CREATE TRIGGER after_order_insert
AFTER INSERT ON Ordini
FOR EACH ROW
BEGIN
    -- Esempio: inserisce un record nella tabella "Audit_ordini" ogni volta che viene inserito un nuovo ordine
    INSERT INTO Audit_ordini (azione, id_ordine) VALUES ('Nuovo ordine inserito', NEW.idOrdine);
END //
DELIMITER ;

-- Testo il trigger inserendo un nuovo ordine
INSERT INTO Ordini (idCliente, idProdotto, dataOrdine) VALUES (1, 1, NOW());

-- Creo un trigger che si attiva dopo l'aggiornamento di un record nella tabella "Clienti" per registrare le modifiche nella tabella "Audit_clienti"
-- Da notare l'uso di IF al posto di WHEN
DELIMITER //
CREATE TRIGGER after_client_update
AFTER UPDATE ON Clienti
FOR EACH ROW
BEGIN
    IF OLD.nome <> NEW.nome OR OLD.cognome <> NEW.cognome THEN
        INSERT INTO Audit_clienti (azione, id_cliente) VALUES (CONCAT('Cliente aggiornato: ', OLD.nome, ' ', OLD.cognome, ' -> ', NEW.nome, ' ', NEW.cognome), OLD.idCliente);
    END IF;
    IF OLD.email <> NEW.email THEN
        INSERT INTO Audit_clienti (azione, id_cliente) VALUES (CONCAT('Email aggiornata: ', OLD.email, ' -> ', NEW.email), OLD.idCliente);
    END IF;
    IF OLD.citta <> NEW.citta THEN
        INSERT INTO Audit_clienti (azione, id_cliente) VALUES (CONCAT('Città aggiornata: ', OLD.citta, ' -> ', NEW.citta), OLD.idCliente);
    END IF;
END //
DELIMITER ;

-- Testo il trigger aggiornando un cliente
UPDATE Clienti SET nome = 'Maria', cognome = 'Rossi', email = 'maria.rossi@example.com', citta = 'Latina' WHERE idCliente = 1;

-- Esempio con DELETE: creo un trigger che si attiva dopo l'eliminazione di un record nella tabella "Prodotti" per registrare l'eliminazione nella tabella "Audit_prodotti"
DELIMITER //
CREATE TRIGGER after_product_delete
AFTER DELETE ON Prodotti
FOR EACH ROW
BEGIN
    INSERT INTO Audit_prodotti (azione, id_prodotto) VALUES (CONCAT('Prodotto eliminato: ', OLD.nome), OLD.idProdotto);
END //
DELIMITER ;

-- Cancellare un trigger
DROP TRIGGER IF EXISTS after_product_delete;