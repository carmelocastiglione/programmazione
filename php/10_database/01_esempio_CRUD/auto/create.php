<?php 
session_start();
@require_once '../db.php';
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['submit'])) {
    $targa = $_POST['Targa'];
    $cilindrata = $_POST['Cilindrata'];
    $prezzo = $_POST['Prezzo'];
    $modello = $_POST['Modello'];
    $colore = $_POST['Colore'];
    $marca = $_POST['Marca'];
    $alimentazione = $_POST['Alimentazione'];
    $codP = $_POST['CodP'];

    try {
        $stmt = $conn->prepare("INSERT INTO Auto (Targa, Cilindrata, Prezzo, Modello, Colore, Marca, Alimentazione, CodP) VALUES (:Targa, :Cilindrata, :Prezzo, :Modello, :Colore, :Marca, :Alimentazione, :CodP)");
        $stmt->execute([
            'Targa' => $targa,
            'Cilindrata' => $cilindrata,
            'Prezzo' => $prezzo,
            'Modello' => $modello,
            'Colore' => $colore,
            'Marca' => $marca,
            'Alimentazione' => $alimentazione,
            'CodP' => $codP,
        ]);
        $_SESSION['success'] = "Auto creata con successo.";
        header("Location: index.php");
        exit();
    } catch (PDOException $e) {
        $_SESSION['error'] = "Creazione fallita: " . $e->getMessage();
        header("Location: create.php");
        exit();
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Autousate: crea auto</title>
</head>
<body>
    <h1>Crea Auto</h1>
    <?php
    if (isset($_SESSION['error'])) {
        echo "<p style='color:red;'>" . htmlspecialchars($_SESSION['error']) . "</p>";
        unset($_SESSION['error']);
    }
    // Fetch all car manufacturers for the dropdown
    try {
        $stmt = $conn->prepare("SELECT * FROM Casa");
        $stmt->execute();
        $case = $stmt->fetchAll();
        if (!$case) {
            echo "Case non trovate.";
            exit();
        }
    } catch (PDOException $e) {
        echo "Query failed: " . $e->getMessage();
        exit();
    }
    // Fetch all owners for the dropdown
    try {
        $stmt = $conn->prepare("SELECT * FROM Proprietario");
        $stmt->execute();
        $proprietari = $stmt->fetchAll();
        if (!$proprietari) {
            echo "Proprietari non trovati.";
            exit();
        }
    } catch (PDOException $e) {
        echo "Query failed: " . $e->getMessage();
        exit();
    }
    ?>
    <form action="" method="post">
        <label for="Targa">Targa:</label>
        <input type="text" id="Targa" name="Targa" required><br><br>

        <label for="Cilindrata">Cilindrata:</label>
        <input type="number" id="Cilindrata" name="Cilindrata" required><br><br>
        
        <label for="Prezzo">Prezzo:</label>
        <input type="number" id="Prezzo" name="Prezzo" required><br><br>

        <label for="Modello">Modello:</label>
        <input type="text" id="Modello" name="Modello" required><br><br>
        
        <label for="Colore">Colore:</label>
        <input type="text" id="Colore" name="Colore" required><br><br>

        <label for="Marca">Marca:</label>
        <select name="Marca" id="Marca" required>
            <?php
            foreach ($case as $casa) {
                echo "<option value=\"" . htmlspecialchars($casa['Nome']) . "\"";
                echo ">" . htmlspecialchars($casa['Nome']) . "</option>";
            }
            ?>
        </select><br><br>

        <label for="Alimentazione">Alimentazione:</label>
        <input type="text" id="Alimentazione" name="Alimentazione" required><br><br>

        <label for="CodP">Proprietario:</label>
        <select name="CodP" id="CodP" required>
            <?php
            foreach ($proprietari as $proprietario) {
                echo "<option value=\"" . htmlspecialchars($proprietario['Codice']) . "\"";
                echo ">" . htmlspecialchars($proprietario['Cognome']) . " " . htmlspecialchars($proprietario['Nome']) . "</option>";
            }
            ?>
        </select><br><br>

        <input type="submit" name="submit" value="Crea Auto">
    </form>
    <a href="index.php"><button>Indietro alla lista</button></a>
</body>
</html>