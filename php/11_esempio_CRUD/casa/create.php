<?php 
session_start();
@require_once '../db.php';
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['submit'])) {
    $nome = $_POST['Nome'];
    $sede = $_POST['Sede'];
    $nazione = $_POST['Nazione'];

    try {
        $stmt = $conn->prepare("INSERT INTO Casa (Nome, Sede, Nazione) VALUES (:Nome, :Sede, :Nazione)");
        $stmt->execute([
            'Nome' => $nome,
            'Sede' => $sede,
            'Nazione' => $nazione,
        ]);
        $_SESSION['success'] = "Casa creata con successo.";
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
    <title>Autousate: crea casa</title>
</head>
<body>
    <h1>Crea Casa</h1>
    <?php
    if (isset($_SESSION['error'])) {
        echo "<p style='color:red;'>" . htmlspecialchars($_SESSION['error']) . "</p>";
        unset($_SESSION['error']);
    }
    ?>
    <form action="" method="post">
        <label for="Nome">Nome:</label>
        <input type="text" id="Nome" name="Nome" placeholder="Nome" required><br><br>

        <label for="Sede">Sede:</label>
        <input type="text" id="Sede" name="Sede" placeholder="Sede" required><br><br>

        <label for="Nazione">Nazione:</label>
        <input type="text" id="Nazione" name="Nazione" placeholder="Nazione" required><br><br>
        
        <input type="submit" name="submit" value="Crea Casa">
    </form>
    <a href="index.php"><button>Indietro alla lista</button></a>
</body>
</html>