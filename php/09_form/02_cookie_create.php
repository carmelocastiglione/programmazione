<?php
    if(isset($_POST['nome']) && isset($_POST['cognome']) && $_SERVER["REQUEST_METHOD"] == "POST") {
        $nome = htmlspecialchars($_POST['nome']);
        $cognome = htmlspecialchars($_POST['cognome']);
        setcookie("nome", $nome, time() + 3600); // Cookie valido per 1 ora
        setcookie("cognome", $cognome, time() + 3600); // Cookie valido per 1 ora
        echo "Cookie impostati.";
    }
?>