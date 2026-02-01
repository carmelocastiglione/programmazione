<?php
session_start();
@require_once '../db.php';
if (isset($_POST['delete'])) {
    $nome = $_POST['Nome'];
    try {
        $stmt = $conn->prepare("DELETE FROM Casa WHERE Nome = :Nome");
        $stmt->execute(['Nome' => $nome]);
        $_SESSION['success'] = "Casa eliminata con successo.";
        header("Location: index.php");
        exit();
    } catch (PDOException $e) {
        $_SESSION['error'] = "Eliminazione fallita: " . $e->getMessage();
        header("Location: index.php");
        exit();
    }
}
?>