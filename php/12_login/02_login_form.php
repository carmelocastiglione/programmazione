<?php
session_start();
?>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
</head>
<body>
    <?php
    if (isset($_SESSION['success'])) {
        echo "<p style='color:green;'>" . htmlspecialchars($_SESSION['success']) . "</p>";
        unset($_SESSION['success']); 
    }
    if (isset($_SESSION['error'])) {
        echo "<p style='color:red;'>" . htmlspecialchars($_SESSION['error']) . "</p>";
        unset($_SESSION['error]);']);
    }
    ?>
    <form action="04_login.php" method="POST">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="submit" value="Login">
    </form>
    <p>Non hai un account? <a href="01_register_form.php">Registrati qui</a>.</p>
</body>
</html>