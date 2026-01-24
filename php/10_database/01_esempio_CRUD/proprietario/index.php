<?php
session_start();
@require_once '../db.php';

try {
    $stmt = $conn->prepare("SELECT * FROM Proprietario");
    $stmt->execute();
    $proprietari = $stmt->fetchAll();
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
    <title>Autousate: proprietario</title>
</head>
<body>
    <h1>Benvenuto nella sezione proprietario</h1>
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
    <a href="create.php"><button>Inserisci un nuovo proprietario</button></a>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Indirizzo</th>
            <th>Città</th>
            <th>Azioni</th>
        </tr>
        <?php
        foreach ($proprietari as $proprietario) {
            echo "<tr>";
            echo "<td>" . htmlspecialchars($proprietario['Codice']) . "</td>";
            echo "<td>" . htmlspecialchars($proprietario['Cognome']) . "</td>";
            echo "<td>" . htmlspecialchars($proprietario['Nome']) . "</td>";
            echo "<td>" . htmlspecialchars($proprietario['Indirizzo']) . "</td>";
            echo "<td>" . htmlspecialchars($proprietario['Città']) . "</td>";
            echo "<td>
                    <a href='show.php?Codice=" . urlencode($proprietario['Codice']) . "'><button>Visualizza</button></a>
                    <a href='edit.php?Codice=" . urlencode($proprietario['Codice']) . "'><button>Modifica</button></a>
                    <form action='delete.php" . "' method='post' onsubmit=\"return confirm('Sei sicuro di voler eliminare questo proprietario?');\" style='display:inline;'>
                        <input type='hidden' name='Codice' value='" . htmlspecialchars($proprietario['Codice']) . "'>
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