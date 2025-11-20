<?php
    // Start the session
    session_start();
    // Reset counter if requested
    if (isset($_POST['reset'])) {
        session_destroy();
    }
    // Redirect back to the main session page
    header("Location: 03_sessioni.php");
    exit();
?>