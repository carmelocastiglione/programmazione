<?php
$driver = "mysql";
$host = "lamp-mysql"; 
$user = "root";
$pass = "root";
$dbname = "autousate";

try {
  $conn = new PDO("$driver:host=$host;dbname=$dbname", $user, $pass);
} catch(PDOException $e) {
  echo "Connection failed: " . $e->getMessage();
  exit();
}

// Inserimento con placeholder posizionali
$cognome = "Rossini";
$nome = "Mariolino";
$indirizzo = "Via Roma 1";
$citta = "Milano";
try {
    $stmt = $conn->prepare("INSERT INTO Proprietario (Cognome, Nome, Indirizzo, Città) VALUES (?, ?, ?, ?)");
    $stmt->execute([$cognome, $nome, $indirizzo, $citta]);
    echo "Inserimento avvenuto con successo.<br />\n";
} catch (PDOException $e) {
    echo "Errore nell'inserimento: " . $e->getMessage();
    exit();
}

// Inserimento con named parameters
$cognome = "Bianchi";
$nome = "Giovanni";
$indirizzo = "Corso Italia 10";
$citta = "Torino";
try {
    $stmt = $conn->prepare("INSERT INTO Proprietario (Cognome, Nome, Indirizzo, Città) VALUES (:cognome, :nome, :indirizzo, :citta)");
    $stmt->execute([
        'cognome' => $cognome,
        'nome' => $nome,
        'indirizzo' => $indirizzo,
        'citta' => $citta
    ]);
    echo "Inserimento avvenuto con successo.<br />\n";
} catch (PDOException $e) {
    echo "Errore nell'inserimento: " . $e->getMessage();
    exit();
}