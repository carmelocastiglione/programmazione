<?php

// CONNESSIONE AL DATABASE
$driver = "mysql";
$host = "localhost";
$user = "root";
$pass = "root";
$dbname = "db";

try {
  $conn = new PDO("$driver:host=$host;dbname=$dbname", $user, $pass);
} catch(PDOException $e) {
  echo "Connection failed: " . $e->getMessage();
  exit();
}

// SELECT
$stmt = $conn->prepare("SELECT * FROM table_name WHERE field1 = :field1 AND field2 = :field2");
$stmt->execute(['field1' => 'value1', 'field2' => 'value2']);
$results = $stmt->fetchAll();
foreach ($results as $row) {
    echo $row['column1'] . " " . $row['column2'] . "<br />\n";
}

// CHIUDO LA CONNESSIONE
$conn = null;

// COOKIES
setcookie("cookie_name", "value", time() + (86400 * 30)); // 86400 = 1 day
setcookie("cookie_name", "", time() - (86400 * 30));
if isset($_COOKIE["cookie_name"]) {
    echo "Cookie value: " . $_COOKIE["cookie_name"];
} else {
    echo "Cookie is not set.";
}

// SESSIONS
session_start();
$_SESSION["session_var"] = "value";
if isset($_SESSION["session_var"]) {
    echo "Session variable value: " . $_SESSION["session_var"];
} else {
    echo "Session variable is not set.";
}
session_destroy();

// GET e POST
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['post_var'])) {
    $post_var = htmlspecialchars($_POST['post_var']);
    echo "POST variable value: " . $post_var;
}

if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET['get_var'])) {
    $get_var = htmlspecialchars($_GET['get_var']);
    echo "GET variable value: " . $get_var;
}
?>