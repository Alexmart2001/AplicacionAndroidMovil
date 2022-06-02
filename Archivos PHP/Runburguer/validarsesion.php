<?php
include_once("conexion.php");
//1. Crear conexión a la Base de Datos
$con=mysqli_connect($host,$usuario,$clave,$bd) or die('Fallo la conexion');
mysqli_set_charset($con,"utf8");
//2. Tomar los campos provenientes de la tabla

$Usuario=isset($_GET["usuario"])?$_GET["usuario"]:'';
$Contrasena=isset($_GET["contrasena"])?$_GET["contrasena"]:'';

   
   $busca = "SELECT * FROM $bd.usuarios WHERE usuario = '$Usuario' AND contrasena = '$Contrasena' ";
   $resultado = mysqli_query($con, $busca);

   while($row = $resultado->fetch_assoc()){
       $array []= array_map('utf8_encode',$row);
       
   }
   echo json_encode($array);

   mysqli_close($con);
   ?>