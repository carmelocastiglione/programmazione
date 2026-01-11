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

$targa = 'CB001LX'; // Targa dell'auto da cancellare

// Cancellazione con positional parameters
try {
    $stmt = $conn->prepare("DELETE FROM Auto WHERE Targa=?");
    $result = $stmt->execute([$targa]); 
    if ($result) {
        echo "Cancellazione avvenuta con successo.<br />\n";
    } else {
        echo "Errore nella cancellazione.<br />\n";
    }
} catch (PDOException $e) {
    echo "Cancellazione fallita: " . $e->getMessage() . "<br />\n";
}

// Cancellazione con named parameters
try {
    $stmt = $conn->prepare("DELETE FROM Auto WHERE Targa=:targa");
    $result = $stmt->execute(['targa' => $targa]); 
    if ($result) {
        echo "Cancellazione avvenuta con successo.<br />\n";
    } else {
        echo "Errore nella cancellazione.<br />\n";
    }
} catch (PDOException $e) {
    echo "Cancellazione fallita: " . $e->getMessage() . "<br />\n";
}