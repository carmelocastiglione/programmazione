<?php 
session_start();
@require_once '../db.php';
if (!isset($_GET['Codice']) || empty($_GET['Codice'])) {
    echo "Codice proprietario non specificato.";
    exit();
}
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['submit'])) {
    $codice = $_POST['Codice'];
    $nome = $_POST['Nome'];
    $cognome = $_POST['Cognome'];
    $indirizzo = $_POST['Indirizzo'];
    $town = $_POST['Town'];

    try {
        $stmt = $conn->prepare("UPDATE Proprietario SET Nome = :Nome, Cognome = :Cognome, Indirizzo = :Indirizzo, Città = :Town WHERE Codice = :Codice");
        $stmt->execute([
            'Nome' => $nome,
            'Cognome' => $cognome,
            'Indirizzo' => $indirizzo,
            'Town' => $town,
            'Codice' => $codice
        ]);
        $_SESSION['success'] = "Proprietario aggiornato con successo.";
        header("Location: index.php");
        exit();
    } catch (PDOException $e) {
        $_SESSION['error'] = "Aggiornamento fallito: " . $e->getMessage();
        header("Location: edit.php?Codice=" . urlencode($codice));
        exit();
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Autousate: modifica proprietario</title>
</head>
<body>
    <h1>Modifica Proprietario</h1>
    <?php
    if (isset($_SESSION['error'])) {
        echo "<p style='color:red;'>" . htmlspecialchars($_SESSION['error']) . "</p>";
        unset($_SESSION['error']);
    }
    try {
        $stmt = $conn->prepare("SELECT * FROM Proprietario WHERE Codice = :Codice");
        $stmt->execute(['Codice' => $_GET['Codice']]);
        $proprietario = $stmt->fetch();
        if (!$proprietario) {
            echo "Proprietario non trovato.";
            exit();
        }
    } catch (PDOException $e) {
        echo "Query failed: " . $e->getMessage();
        exit();
    }
    ?>
    <form action="" method="post">
        <input type="hidden" name="Codice" value="<?php echo htmlspecialchars($proprietario['Codice']); ?>">

        <label for="Nome">Nome:</label>
        <input type="text" id="Nome" name="Nome" value="<?php echo htmlspecialchars($proprietario['Nome']); ?>" required><br><br>

        <label for="Cognome">Cognome:</label>
        <input type="text" id="Cognome" name="Cognome" value="<?php echo htmlspecialchars($proprietario['Cognome']); ?>" required><br><br>

        <label for="Indirizzo">Indirizzo:</label>
        <input type="text" id="Indirizzo" name="Indirizzo" value="<?php echo htmlspecialchars($proprietario['Indirizzo']); ?>" required><br><br>

        <label for="Town">Città:</label>
        <input type="text" id="Town" name="Town" value="<?php echo htmlspecialchars($proprietario['Città']); ?>" required><br><br>

        <input type="submit" name="submit" value="Aggiorna Proprietario">
    </form>
    <a href="index.php"><button>Indietro alla lista</button></a>
</body>
</html>