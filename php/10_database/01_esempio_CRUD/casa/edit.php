<?php 
session_start();
@require_once '../db.php';
if (!isset($_GET['Nome']) || empty($_GET['Nome'])) {
    echo "Nome casa non specificato.";
    exit();
}
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['submit'])) {
    $nome = $_POST['Nome'];
    $sede = $_POST['Sede'];
    $nazione = $_POST['Nazione'];
    try {
        $stmt = $conn->prepare("UPDATE Casa SET Nome = :Nome, Sede = :Sede, Nazione = :Nazione WHERE Nome = :Nome");
        $stmt->execute([
            'Nome' => $nome,
            'Sede' => $sede,
            'Nazione' => $nazione,
        ]);
        $_SESSION['success'] = "Casa aggiornata con successo.";
        header("Location: index.php");
        exit();
    } catch (PDOException $e) {
        $_SESSION['error'] = "Aggiornamento fallito: " . $e->getMessage();
        header("Location: edit.php?Nome=" . urlencode($nome));
        exit();
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Autousate: modifica casa</title>
</head>
<body>
    <h1>Modifica Casa</h1>
    <?php
    if (isset($_SESSION['error'])) {
        echo "<p style='color:red;'>" . htmlspecialchars($_SESSION['error']) . "</p>";
        unset($_SESSION['error']);
    }
    try {
        $stmt = $conn->prepare("SELECT * FROM Casa WHERE Nome = :Nome");
        $stmt->execute(['Nome' => $_GET['Nome']]);
        $casa = $stmt->fetch();
        if (!$casa) {
            echo "Casa non trovata.";
            exit();
        }
    } catch (PDOException $e) {
        echo "Query failed: " . $e->getMessage();
        exit();
    }
    ?>
    <form action="" method="post">
        
        <label for="Nome">Nome:</label>
        <input type="text" id="Nome" name="Nome" value="<?php echo htmlspecialchars($casa['Nome']); ?>" required><br><br>

        <label for="Sede">Sede:</label>
        <input type="text" id="Sede" name="Sede" value="<?php echo htmlspecialchars($casa['Sede']); ?>" required><br><br>

        <label for="Nazione">Nazione:</label>
        <input type="text" id="Nazione" name="Nazione" value="<?php echo htmlspecialchars($casa['Nazione']); ?>" required><br><br>

        <input type="submit" name="submit" value="Aggiorna Casa">
    </form>
    <a href="index.php"><button>Indietro alla lista</button></a>
</body>
</html>