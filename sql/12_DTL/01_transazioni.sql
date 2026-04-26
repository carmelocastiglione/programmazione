-- Una transazione è un'unità di lavoro che viene eseguita in modo atomico, consistente, isolato e duraturo (ACID).
-- Atomicità: tutte le operazioni all'interno di una transazione devono essere completate con successo o nessuna di esse deve essere eseguita.
-- Consistenza: una transazione deve portare il database da uno stato valido a un altro stato valido, mantenendo l'integrità dei dati.
-- Isolamento: le operazioni di una transazione devono essere isolate dalle altre transazioni, evitando interferenze e garantendo la coerenza dei dati.
-- Durabilità: una volta che una transazione è stata committata, le modifiche apportate al database devono essere permanenti, anche in caso di guasti o crash del sistema.
-- In SQL, una transazione viene avviata con il comando BEGIN TRANSACTION e terminata con COMMIT o ROLLBACK.
-- Esempio di transazione che trasferisce denaro da un conto a un altro:

CREATE DATABASE conti;
USE conti;
CREATE TABLE conti (
    id_conto INT PRIMARY KEY,
    saldo DECIMAL(10, 2)
);

INSERT INTO conti (id_conto, saldo) VALUES (1, 1000.00);
INSERT INTO conti (id_conto, saldo) VALUES (2, 500.00);

-- La sintassi per eseguire una transazione varia a seconda del sistema di gestione del database (DBMS) utilizzato, ma in generale si utilizza il comando START TRANSACTION per avviare la transazione, seguito dalle operazioni da eseguire e infine il comando COMMIT per confermare le modifiche o ROLLBACK per annullarle in caso di errori.
START TRANSACTION;
UPDATE conti
SET saldo = saldo - 100
WHERE id_conto = 1;
UPDATE conti
SET saldo = saldo + 100
WHERE id_conto = 2;
COMMIT;

START TRANSACTION;
UPDATE conti
SET saldo = saldo - 100
WHERE id_conto = 1;
UPDATE conti
SET saldo = saldo + 100
WHERE id_conto = 2;
ROLLBACK;