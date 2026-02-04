<?php
session_start();
@require_once '../db.php';
if (isset($_POST['delete'])) {
    $codice = $_POST['Codice'];
    try {
        $stmt = $conn->prepare("DELETE FROM Proprietario WHERE Codice = :Codice");
        $stmt->execute(['Codice' => $codice]);
        $_SESSION['success'] = "Proprietario eliminato con successo.";
        header("Location: index.php");
        exit();
    } catch (PDOException $e) {
        $_SESSION['error'] = "Eliminazione fallita: " . $e->getMessage();
        header("Location: index.php");
        exit();
    }
}
?>