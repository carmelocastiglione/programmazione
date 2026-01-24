<?php 
@require_once '../db.php';
if (!isset($_GET['Nome']) || empty($_GET['Nome'])) {
    echo "Nome casa non specificato.";
    exit();
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Autousate: visualizza casa</title>
</head>
<body>
    <h1>Visualizza Casa</h1>
    <?php
    try {
        $stmt = $conn->prepare("SELECT * FROM Casa WHERE Nome = :Nome");
        $stmt->execute([':Nome' => $_GET['Nome']]);
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
    <p>Nome: <?php echo htmlspecialchars($casa['Nome']); ?></p>
    <p>Sede: <?php echo htmlspecialchars($casa['Sede']); ?></p>
    <p>Nazione: <?php echo htmlspecialchars($casa['Nazione']); ?></p>
    <a href="index.php"><button>Indietro alla lista</button></a>
</body>
</html>