<?php
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
// Check if session token cookie exists
if (isset($_COOKIE['session_token'])) {
    $session_token = $_COOKIE['session_token'];
    try {
        // Delete session from database
        $stmt = $conn->prepare("DELETE FROM sessioni WHERE session_token = :session_token");
        $stmt->execute(['session_token' => $session_token]);
        
        // Clear the session cookie
        setcookie('session_token', '', time() - 86400 * 7, '/'); // Expire the cookie
        
        header("Location: 02_login_form.php");
        exit();
    } catch (PDOException $e) {
        echo "Errore durante il logout: " . $e->getMessage() . "<br />\n";
        exit();
    }
} else {
    header("Location: 02_login_form.php");
    exit();
}
$conn = null;
?>