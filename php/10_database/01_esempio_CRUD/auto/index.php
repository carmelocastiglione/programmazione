<?php
session_start();
@require_once '../db.php';

try {
    $stmt = $conn->prepare(
        "SELECT Targa, Cilindrata, Prezzo, Modello, C.Nome AS NomeCasa, Colore, Alimentazione, Cognome, P.Nome AS NomeProprietario
        FROM Auto AS A, Casa AS C, Proprietario AS P 
        WHERE A.CodP = P.Codice AND A.Marca = C.Nome
        ");
    $stmt->execute();
    $auto = $stmt->fetchAll();
} catch (PDOException $e) {
    echo "Query failed: " . $e->getMessage();
    exit();
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Autousate: auto</title>
</head>
<body>
    <h1>Benvenuto nella sezione auto</h1>
    <?php
    if (isset($_SESSION['success'])) {
        echo "<p style='color:green;'>" . htmlspecialchars($_SESSION['success']) . "</p>";
        unset($_SESSION['success']);
    }
    if (isset($_SESSION['error'])) {
        echo "<p style='color:red;'>" . htmlspecialchars($_SESSION['error']) . "</p>";
        unset($_SESSION['error']);
    }
    ?>
    <a href="create.php"><button>Inserisci una nuova auto</button></a>
    <table>
        <tr>
            <th>Targa</th>
            <th>Cilindrata</th>
            <th>Prezzo</th> 
            <th>Modello</th> 
            <th>Colore</th>
            <th>Marca</th>
            <th>Alimentazione</th>
            <th>Proprietario</th>
            <th>Azioni</th>
        </tr>
        <?php
        foreach ($auto as $a) {

            echo "<tr>";
            echo "<td>" . htmlspecialchars($a['Targa']) . "</td>";
            echo "<td>" . htmlspecialchars($a['Cilindrata']) . "</td>";
            echo "<td>" . htmlspecialchars($a['Prezzo']) . "</td>";
            echo "<td>" . htmlspecialchars($a['Modello']) . "</td>";
            echo "<td>" . htmlspecialchars($a['Colore']) . "</td>";
            echo "<td>" . htmlspecialchars($a['NomeCasa']) . "</td>";
            echo "<td>" . htmlspecialchars($a['Alimentazione']) . "</td>";
            echo "<td>" . htmlspecialchars($a['Cognome']) . " " . htmlspecialchars($a['NomeProprietario']) . "</td>";
            echo "<td>" . "
                    <a href='show.php?Targa=" . urlencode($a['Targa']) . "'><button>Visualizza</button></a>
                    <a href='edit.php?Targa=" . urlencode($a['Targa']) . "'><button>Modifica</button></a>
                    <form action='delete.php" . "' method='post' onsubmit=\"return confirm('Sei sicuro di voler eliminare questa auto?');\" style='display:inline;'>
                        <input type='hidden' name='Targa' value='" . htmlspecialchars($a['Targa']) . "'>
                        <input type='submit' name='delete' value='Elimina'>
                    </form>
                  </td>";
            echo "</tr>";
        }
        ?>
    </table>
    <a href="../index.php">Home page</a>
</body>
</html>