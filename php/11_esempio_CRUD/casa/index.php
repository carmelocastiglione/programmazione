<?php
session_start();
@require_once '../db.php';

try {
    $stmt = $conn->prepare("SELECT * FROM Casa");
    $stmt->execute();
    $case = $stmt->fetchAll();
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
    <title>Autousate: casa</title>
</head>
<body>
    <h1>Benvenuto nella sezione casa</h1>
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
    <a href="create.php"><button>Inserisci una nuova casa</button></a>
    <table>
        <tr>
            <th>Nome</th>
            <th>Sede</th>
            <th>Nazione</th>
        </tr>
        <?php
        foreach ($case as $casa) {
            echo "<tr>";
            echo "<td>" . htmlspecialchars($casa['Nome']) . "</td>";
            echo "<td>" . htmlspecialchars($casa['Sede']) . "</td>";
            echo "<td>" . htmlspecialchars($casa['Nazione']) . "</td>";
            echo "<td>
                    <a href='show.php?Nome=" . urlencode($casa['Nome']) . "'><button>Visualizza</button></a>
                    <a href='edit.php?Nome=" . urlencode($casa['Nome']) . "'><button>Modifica</button></a>
                    <form action='delete.php" . "' method='post' onsubmit=\"return confirm('Sei sicuro di voler eliminare questa casa?');\" style='display:inline;'>
                        <input type='hidden' name='Nome' value='" . htmlspecialchars($casa['Nome']) . "'>
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