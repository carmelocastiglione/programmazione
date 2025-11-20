<?php
    if(isset($_COOKIE['nome']) && isset($_COOKIE['cognome'])) {
        echo "Cookie impostati:<br>";
        echo "Nome: " . htmlspecialchars($_COOKIE['nome']) . "<br>";
        echo "Cognome: " . htmlspecialchars($_COOKIE['cognome']) . "<br>";
    } else {
        echo "Cookie non impostati.<br>";
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
    <form action="02_cookie_create.php" method="POST">
        Nome: <input type="text" name="nome" id="nome">
        Cognome: <input type="text" name="cognome" id="cognome">
        <input type="submit" value="Invia">
    </form>
    <form action="02_cookie_delete.php" method="POST">
        <input type="hidden" name="delete_cookies" value="1">
        <input type="submit" value="Elimina Cookie">
    </form>   
</body>
</html>