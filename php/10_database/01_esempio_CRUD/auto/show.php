<?php 
@require_once '../db.php';
if (!isset($_GET['Targa']) || empty($_GET['Targa'])) {
    echo "Targa auto non specificata.";
    exit();
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Autousate: visualizza auto</title>
</head>
<body>
    <h1>Visualizza Auto</h1>
    <?php
    try {
        $stmt = $conn->prepare("SELECT * FROM Auto, Proprietario WHERE Targa = :Targa AND Auto.CodP = Proprietario.Codice");
        $stmt->execute([':Targa' => $_GET['Targa']]);
        $auto = $stmt->fetch();
        if (!$auto) {
            echo "Auto non trovata.";
            exit();
        }
    } catch (PDOException $e) {
        echo "Query failed: " . $e->getMessage();
        exit();
    }
    ?>
    <p>Targa: <?php echo htmlspecialchars($auto['Targa']); ?></p>
    <p>Cilindrata: <?php echo htmlspecialchars($auto['Cilindrata']); ?></p>
    <p>Prezzo: <?php echo htmlspecialchars($auto['Prezzo']); ?></p>
    <p>Modello: <?php echo htmlspecialchars($auto['Modello']); ?></p>
    <p>Colore: <?php echo htmlspecialchars($auto['Colore']); ?></p>
    <p>Marca: <?php echo htmlspecialchars($auto['Marca']); ?></p>
    <p>Alimentazione: <?php echo htmlspecialchars($auto['Alimentazione']); ?></p>
    <p>Proprietario: <?php echo htmlspecialchars($auto['Cognome']) . " " . htmlspecialchars($auto['Nome']); ?></p>
    <a href="index.php"><button>Indietro alla lista</button></a>
</body>
</html>