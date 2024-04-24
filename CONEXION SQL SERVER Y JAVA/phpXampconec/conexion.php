<?php
$servername = "localhost"; // Nombre del servidor
$username = "root"; // Nombre de usuario de MySQL
$password = ""; // Contraseña de MySQL
$database = "bdd_barberia"; // Nombre de la base de datos

// Crear conexión
$conn = new mysqli($servername, $username, $password, $database);

// Verificar conexión
if ($conn->connect_error) {
    die("La conexión ha fallado: " . $conn->connect_error);
} else {
    echo "Conexión exitosa";
}
?>
