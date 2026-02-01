<?php 
session_start();
@require_once '../db.php';
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['submit'])) {
    $nome = $_POST['Nome'];
    $cognome = $_POST['Cognome'];
    $indirizzo = $_POST['Indirizzo'];
    $town = $_POST['Town'];

    try {
        $stmt = $conn->prepare("INSERT INTO Proprietario (Nome, Cognome, Indirizzo, Città) VALUES (:Nome, :Cognome, :Indirizzo, :Town)");
        $stmt->execute([
            'Nome' => $nome,
            'Cognome' => $cognome,
            'Indirizzo' => $indirizzo,
            'Town' => $town,
        ]);
        $_SESSION['success'] = "Proprietario creato con successo.";
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
    <title>Autousate: crea proprietario</title>
</head>
<body>
    <h1>Crea Proprietario</h1>
    <?php
    if (isset($_SESSION['error'])) {
        echo "<p style='color:red;'>" . htmlspecialchars($_SESSION['error']) . "</p>";
        unset($_SESSION['error']);
    }
    ?>
    <form action="" method="post">
        <label for="Nome">Nome:</label>
        <input type="text" id="Nome" name="Nome" placeholder="Nome" required><br><br>

        <label for="Cognome">Cognome:</label>
        <input type="text" id="Cognome" name="Cognome" placeholder="Cognome" required><br><br>

        <label for="Indirizzo">Indirizzo:</label>
        <input type="text" id="Indirizzo" name="Indirizzo" placeholder="Indirizzo" required><br><br>

        <label for="Town">Città:</label>
        <input type="text" id="Town" name="Town" placeholder="Città" required><br><br>

        <input type="submit" name="submit" value="Crea Proprietario">
    </form>
    <a href="index.php"><button>Indietro alla lista</button></a>
</body>
</html>