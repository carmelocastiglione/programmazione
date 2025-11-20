<?php
    if(isset($_POST['delete_cookies']) && $_SERVER["REQUEST_METHOD"] == "POST") {
        setcookie("nome", "", time() - 3600); // Elimina il cookie
        setcookie("cognome", "", time() - 3600); // Elimina il cookie
        echo "Cookie eliminati.";
    }
?>