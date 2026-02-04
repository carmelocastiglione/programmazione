<?php
session_start();
$driver = "mysql";
$host = "lamp-mysql"; 
$user = "root";
$pass = "root";
$dbname = "authentication";

try {
  $conn = new PDO("$driver:host=$host;dbname=$dbname", $user, $pass);
} catch(PDOException $e) {
  echo "Connection failed: " . $e->getMessage();
  exit();
}

$email = htmlspecialchars($_POST['email']) ?? '';
$password = htmlspecialchars($_POST['password']) ?? '';
$hashed_password = password_hash($password, PASSWORD_BCRYPT);

try {
    $stmt = $conn->prepare("INSERT INTO utenti (email, password) VALUES (:email, :password)");
    $stmt->execute(['email' => $email, 'password' => $hashed_password]);
    
    // Redirect to login page on success
    $_SESSION['success'] = "Registrazione avvenuta con successo. Effettua il login.";
    header("Location: 02_login_form.php");
    exit();
} catch (PDOException $e) {
    // Redirect back to registration form on failure
    $_SESSION['error'] = "Errore durante la registrazione: " . $e->getMessage();
    header("Location: 01_register_form.php");
    exit();
}
$conn = null;
?>