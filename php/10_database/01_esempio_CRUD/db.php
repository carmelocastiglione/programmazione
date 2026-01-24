<?php
        $driver = 'mysql';
        $host = 'lamp-mysql';
        $dbname = 'autousate';
        $username = 'root';
        $password = 'root';

        try {
            $conn = new PDO("$driver:host=$host;dbname=$dbname", $username, $password);
        } catch (PDOException $e) {
            echo "Connection failed: " . $e->getMessage();
            exit();
        }
?>