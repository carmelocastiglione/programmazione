<?php
session_start();
// Inizializza i soldi in banca se non esistono
if (!isset($_SESSION['soldi'])) {
    $_SESSION['soldi'] = 10000; // Soldi iniziali
}
// Processa il form se inviato
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $importo = floatval($_POST['importo']);
    // Sottrai l'importo dai soldi in banca
    $_SESSION['soldi'] = $_SESSION['soldi'] - $importo;
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form vulnerabile</title>
</head>
<body>
    <h1>Questo form è vulnerabile a CSRF</h1>
    <p>CSRF è un attacco che induce la vittima a inviare una richiesta dannosa. Eredita l'identità e i privilegi della vittima per eseguire una funzione indesiderata a suo nome.</p>
    <form method="POST" action="">
        <label for="importo">Inserisci l'importo da trasferire:</label>
        <input type="number" id="importo" name="importo" required>
        <input type="submit" value="Invia"> 
    </form>
    <h2>Soldi in banca:</h2> 
    <p><?= $_SESSION['soldi'] ?>€</p>
</body>
</html>