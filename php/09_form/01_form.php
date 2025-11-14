<?php 
if ($_SERVER["REQUEST_METHOD"] == "GET") {
    $nome = htmlspecialchars($_GET['nome']);
    $cognome = htmlspecialchars($_GET['cognome']);
    echo "Nome: $nome<br>";
    echo "Cognome: $cognome<br>";
}
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nome = htmlspecialchars($_POST['nome']);
    $cognome = htmlspecialchars($_POST['cognome']);
    echo "Nome: $nome<br>";
    echo "Cognome: $cognome<br>";
}
?>