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

$targa = 'CB001LX'; // Targa dell'auto da modificare
$colore = 'Blu'; // Nuovo colore da impostare

// Update con positional parameters
try {
    $stmt = $conn->prepare("UPDATE Auto SET Colore=? WHERE Targa=?");
    $result = $stmt->execute([$colore, $targa]); 
    if ($result) {
        echo "Record modificato con successo.<br />\n";
    } else {
        echo "Errore nella modifica del record.<br />\n";
    }
} catch (PDOException $e) {
    echo "Modifica fallita: " . $e->getMessage() . "<br />\n";
}

// Update con named parameters
try {
    $stmt = $conn->prepare("UPDATE Auto SET Colore=:colore WHERE Targa=:targa");
    $result = $stmt->execute(['colore' => $colore, 'targa' => $targa]); 
    if ($result) {
        echo "Record modificato con successo.<br />\n";
    } else {
        echo "Errore nella modifica del record.<br />\n";
    }
} catch (PDOException $e) {
    echo "Modifica fallita: " . $e->getMessage() . "<br />\n";
}   