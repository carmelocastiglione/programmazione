<?php
$driver = "mysql";
$host = "lamp-mysql"; // Qui sto usando il nome del container Docker, non "localhost" come si farebbe normalmente
$user = "root";
$pass = "root";
$dbname = "autousate";

try {
  $conn = new PDO("$driver:host=$host;dbname=$dbname", $user, $pass);
  echo "Connected successfully";
} catch(PDOException $e) {
  echo "Connection failed: " . $e->getMessage();
  exit();
}
$conn = null;
?>