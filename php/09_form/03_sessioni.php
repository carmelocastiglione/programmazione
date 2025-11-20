<?php
    // Start the session
    session_start();
    // Set session variables
    if (!isset($_SESSION['visits'])) {
        $_SESSION['visits'] = 0;
    } else {
        $_SESSION['visits']++;
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Session Example</h1>
    <p>You have visited this page <?php echo $_SESSION['visits']; ?> times during this session.</p>
    <form method="post" action="03_sessioni_destroy.php">
        <button type="submit" name="reset">Reset Counter</button>
    </form>
</body>
</html>