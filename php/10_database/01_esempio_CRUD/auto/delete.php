<?php
session_start();
@require_once '../db.php';
if (isset($_POST['delete'])) {
    $targa = $_POST['Targa'];
    try {
        $stmt = $conn->prepare("DELETE FROM Auto WHERE Targa = :Targa");
        $stmt->execute(['Targa' => $targa]);
        $_SESSION['success'] = "Auto eliminata con successo.";
        header("Location: index.php");
        exit();
    } catch (PDOException $e) {
        $_SESSION['error'] = "Eliminazione fallita: " . $e->getMessage();
        header("Location: index.php");
        exit();
    }
}
?>