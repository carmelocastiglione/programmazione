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

$email = htmlspecialchars($_POST['email']) ?? '';
$password = htmlspecialchars($_POST['password']) ?? '';
try {
    $stmt = $conn->prepare("SELECT * FROM utenti WHERE email=:email");
    $stmt->execute(['email' => $email]);
    $user = $stmt->fetch();
    
    if ($user && password_verify($password, $user['password'])) {
        // Generate a unique session token
        $session_token = bin2hex(random_bytes(32));
        
        // Store session in database
        $stmt = $conn->prepare("INSERT INTO sessioni (user_id, session_token) VALUES (:user_id, :session_token)");
        $stmt->execute(['user_id' => $user['id'], 'session_token' => $session_token]);
        
        // Set cookie to remember the session
        setcookie('session_token', $session_token, time() + (86400 * 7), '/'); // 7 days
        
        // Redirect to dashboard page on success
        header("Location: 05_dashboard.php");
        exit();
    } else {
        // Redirect back to login form on failure
        $_SESSION['error'] = "Email o password non validi.";
        header("Location: 02_login_form.php");
        exit();
        }
} catch (PDOException $e) {
    // Redirect back to login form on failure
    $_SESSION['error'] = "Login fallito: " . $e->getMessage();
    header("Location: 02_login_form.php");
    exit();
}
$conn = null;
?>