-- I savepoint sono dei punti di salvataggio all'interno di una transazione. Permettono di annullare solo una parte della transazione, invece di dover annullare tutto.
-- La sintassi per creare un savepoint è la seguente:
-- SAVEPOINT nome_savepoint;
-- Per annullare le modifiche fino a un savepoint specifico, si utilizza il comando ROLLBACK TO SAVEPOINT:
-- ROLLBACK TO SAVEPOINT nome_savepoint;

START TRANSACTION;
INSERT INTO conti (id_conto, saldo) VALUES (3, 200.00);
SAVEPOINT sp1;
INSERT INTO conti (id_conto, saldo) VALUES (4, 300.00);
ROLLBACK TO SAVEPOINT sp1;
COMMIT;