<?php
session_start();
// Sesioan erabiltzailea gorde
$_SESSION['web_erabiltzaile'] = $_POST["webErabiltzaile"];
header("Location: nagusia.php");
?>
