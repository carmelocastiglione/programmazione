<?php 
// Check if the form is submitted
// Retrieve and sanitize form data with htmlspecialchars to prevent XSS attacks
// Example: 'OR 1=1--
if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET['nome']) && isset($_GET['cognome'])) {
    $nome = htmlspecialchars($_GET['nome']);
    $cognome = htmlspecialchars($_GET['cognome']);
    echo "Nome: $nome<br>";
    echo "Cognome: $cognome<br>";
}
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['nome']) && isset($_POST['cognome'])) {
    $nome = htmlspecialchars($_POST['nome']);
    $cognome = htmlspecialchars($_POST['cognome']);
    echo "Nome: $nome<br>";
    echo "Cognome: $cognome<br>";
}
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['hobby'])) {
    $hobby = $_POST['hobby'];
    print_r($hobby);
    echo "<br>";
    echo "Hobby selezionati:<br>";
    foreach ($hobby as $h) {
        echo htmlspecialchars($h) . "<br>";
    }
}
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['genere'])) {
    $genere = htmlspecialchars($_POST['genere']);
    echo "Genere: $genere<br>";
}
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['nazione'])) {
    $nazione = htmlspecialchars($_POST['nazione']);
    echo "Nazione: $nazione<br>";
}
?>