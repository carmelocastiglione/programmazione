<?php 
session_start();
@require_once '../db.php';
if (!isset($_GET['Targa']) || empty($_GET['Targa'])) {
    echo "Targa auto non specificata.";
    exit();
}
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
        $stmt = $conn->prepare("UPDATE Auto SET Targa = :Targa, Cilindrata = :Cilindrata, Prezzo = :Prezzo, Modello = :Modello, Colore = :Colore, Marca = :Marca, Alimentazione = :Alimentazione, CodP = :CodP WHERE Targa = :Targa");
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
        $_SESSION['success'] = "Auto aggiornata con successo.";
        header("Location: index.php");
        exit();
    } catch (PDOException $e) {
        $_SESSION['error'] = "Aggiornamento fallito: " . $e->getMessage();
        header("Location: edit.php?Targa=" . urlencode($targa));
        exit();
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Autousate: modifica auto</title>
</head>
<body>
    <h1>Modifica Auto</h1>
    <?php
    if (isset($_SESSION['error'])) {
        echo "<p style='color:red;'>" . htmlspecialchars($_SESSION['error']) . "</p>";
        unset($_SESSION['error']);
    }
    // Fetch the current car data
    try {
        $stmt = $conn->prepare("SELECT * FROM Auto WHERE Targa = :Targa");
        $stmt->execute(['Targa' => $_GET['Targa']]);
        $auto = $stmt->fetch();
        if (!$auto) {
            echo "Auto non trovata.";
            exit();
        }
    } catch (PDOException $e) {
        echo "Query failed: " . $e->getMessage();
        exit();
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
        <input type="text" id="Targa" name="Targa" value="<?php echo htmlspecialchars($auto['Targa']); ?>" required><br><br>

        <label for="Cilindrata">Cilindrata:</label>
        <input type="number" id="Cilindrata" name="Cilindrata" value="<?php echo htmlspecialchars($auto['Cilindrata']); ?>" required><br><br>
        
        <label for="Prezzo">Prezzo:</label>
        <input type="number" id="Prezzo" name="Prezzo" value="<?php echo htmlspecialchars($auto['Prezzo']); ?>" required><br><br>

        <label for="Modello">Modello:</label>
        <input type="text" id="Modello" name="Modello" value="<?php echo htmlspecialchars($auto['Modello']); ?>" required><br><br>
        
        <label for="Colore">Colore:</label>
        <input type="text" id="Colore" name="Colore" value="<?php echo htmlspecialchars($auto['Colore']); ?>" required><br><br>

        <label for="Marca">Marca:</label>
        <select name="Marca" id="Marca" required>
            <?php
            foreach ($case as $casa) {
                echo "<option value=\"" . htmlspecialchars($casa['Nome']) . "\"";
                if ($casa['Nome'] == $auto['Marca']) {
                    echo " selected";
                }
                echo ">" . htmlspecialchars($casa['Nome']) . "</option>";
            }
            ?>
        </select><br><br>

        <label for="Alimentazione">Alimentazione:</label>
        <input type="text" id="Alimentazione" name="Alimentazione" value="<?php echo htmlspecialchars($auto['Alimentazione']); ?>" required><br><br>

        <label for="CodP">Proprietario:</label>
        <select name="CodP" id="CodP" required>
            <?php
            foreach ($proprietari as $proprietario) {
                echo "<option value=\"" . htmlspecialchars($proprietario['Codice']) . "\"";
                if ($proprietario['Codice'] == $auto['CodP']) {
                    echo " selected";
                }
                echo ">" . htmlspecialchars($proprietario['Cognome']) . " " . htmlspecialchars($proprietario['Nome']) . "</option>";
            }
            ?>
        </select><br><br>

        <input type="submit" name="submit" value="Aggiorna Auto">
    </form>
    <a href="index.php"><button>Indietro alla lista</button></a>
</body>
</html>