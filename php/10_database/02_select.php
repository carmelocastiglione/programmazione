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

// Select di tutti i record dalla tabella Auto
$stmt = $conn->query("SELECT * FROM Auto");
while ($row = $stmt->fetch()) {
    echo $row['Targa']." ".$row['Marca']." ".$row['Modello']." ".$row['Colore']."<br />\n";
}

echo "<hr />\n";

// Select con fetchAll (alternativa)
$stmt = $conn->query("SELECT * FROM Auto");
$rows = $stmt->fetchAll();
foreach ($rows as $row) {
    echo $row['Targa']." ".$row['Marca']." ".$row['Modello']." ".$row['Colore']."<br />\n";
}

echo "<hr />\n";

// Select con prepared statement
// da usare per query con parametri
$targa = 'CB001LX'; // esempio di targa da cercare
$stmt = $conn->prepare("SELECT * FROM Auto WHERE Targa=?");
$stmt->execute([$targa]); 
$auto = $stmt->fetch();
echo $auto['Targa']." ".$auto['Marca']." ".$auto['Modello']." ".$auto['Colore']."<br />\n";

echo "<hr />\n";

// Select con named parameters
$targa = 'CB001LX';
$stmt = $conn->prepare("SELECT * FROM Auto WHERE Targa=:targa");
$stmt->execute(['targa' => $targa]); 
$auto = $stmt->fetch();
echo $auto['Targa']." ".$auto['Marca']." ".$auto['Modello']." ".$auto['Colore']."<br />\n";

echo "<hr />\n";

// Select con parametri multipli
$marca = 'Fiat';
$modello = 'Panda';
$stmt = $conn->prepare("SELECT * FROM Auto WHERE Marca=? AND Modello=?");
$stmt->execute([$marca, $modello]);
$autos = $stmt->fetchAll();
foreach ($autos as $auto) {
    echo $auto['Targa']." ".$auto['Marca']." ".$auto['Modello']." ".$auto['Colore']."<br />\n";
}

echo "<hr />\n";

// Select con named parameters multipli
$marca = 'Fiat';
$modello = 'Panda';
$stmt = $conn->prepare("SELECT * FROM Auto WHERE Marca=:marca AND Modello=:modello");
$stmt->execute(['marca' => $marca, 'modello' => $modello]);
$autos = $stmt->fetchAll();
foreach ($autos as $auto) {
    echo $auto['Targa']." ".$auto['Marca']." ".$auto['Modello']." ".$auto['Colore']."<br />\n";
}

echo "<hr />\n";

// Chiudo la connessione
$conn = null;
?>