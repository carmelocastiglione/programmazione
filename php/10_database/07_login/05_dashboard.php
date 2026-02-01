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

$is_logged_in = false;
$user_email = '';
$user_id = 0;

// Check if session token cookie exists
if (isset($_COOKIE['session_token'])) {
    $session_token = $_COOKIE['session_token'];
    
    try {
        // Find session in database
        $stmt = $conn->prepare("SELECT u.email, s.user_id FROM sessioni s 
                              JOIN utenti u ON s.user_id = u.id 
                              WHERE s.session_token = :session_token");
        $stmt->execute(['session_token' => $session_token]);
        $session = $stmt->fetch();
        
        if ($session) {
            $is_logged_in = true;
            $user_id = $session['user_id'];
            $user_email = $session['email'];
        }
    } catch (PDOException $e) {
        echo "Database error: " . $e->getMessage();
    }
}

$conn = null;
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
</head>
<body>
    <?php if ($is_logged_in): ?>
        <h1>Ciao, <?= htmlspecialchars($user_email); ?> (id: <?= htmlspecialchars($user_id); ?>)!</h1>
        <p>Sei connesso.</p>
        <a href="06_logout.php">Logout</a>
    <?php else: ?>
        <h1>Accesso Negato</h1>
        <p>Non sei connesso. Per favore <a href="02_login_form.php">accedi</a> prima.</p>
    <?php endif; ?>
</body>
</html>