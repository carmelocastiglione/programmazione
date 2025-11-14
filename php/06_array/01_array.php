<?php
$nomi = array("Alice", "Bob", "Charlie");

// Iterazione con for e foreach
for($i = 0; $i < count($nomi); $i++) {
    echo "Ciao, " . $nomi[$i] . "!<br>";
}

foreach($nomi as $nome) {
    echo "Ciao, " . $nome . "!<br>";
}

// Accesso a un elemento specifico
echo "Il secondo nome è: " . $nomi[1] . "<br>";

// Aggiunta di un elemento all'array
$nomi[] = "Diana";
echo "Ciao, " . $nomi[3] . "!<br>";
?>