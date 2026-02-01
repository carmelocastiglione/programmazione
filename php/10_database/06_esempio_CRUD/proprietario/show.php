<?php 
@require_once '../db.php';
if (!isset($_GET['Codice']) || empty($_GET['Codice'])) {
    echo "Codice proprietario non specificato.";
    exit();
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Autousate: visualizza proprietario</title>
</head>
<body>
    <h1>Visualizza Proprietario</h1>
    <?php
    try {
        $stmt = $conn->prepare("SELECT * FROM Proprietario WHERE Codice = :Codice");
        $stmt->execute([':Codice' => $_GET['Codice']]);
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
    <p>ID: <?php echo htmlspecialchars($proprietario['Codice']); ?></p>
    <p>Nome: <?php echo htmlspecialchars($proprietario['Nome']); ?></p>
    <p>Cognome: <?php echo htmlspecialchars($proprietario['Cognome']); ?></p>
    <p>Indirizzo: <?php echo htmlspecialchars($proprietario['Indirizzo']); ?></p>
    <p>Città: <?php echo htmlspecialchars($proprietario['Città']); ?></p>
    <a href="index.php"><button>Indietro alla lista</button></a>
</body>
</html>