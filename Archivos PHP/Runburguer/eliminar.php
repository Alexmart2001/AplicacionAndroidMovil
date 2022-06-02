<?php
    include_once("conexion.php");
    $con = mysqli_connect($host, $usuario, $clave, $bd) or die('Fallo la conexion');
    mysqli_set_charset($con, "utf-8");

    $Usuario=isset($_GET["usuario"])?$_GET["usuario"]:'';
   
    $eliminar = "DELETE FROM $bd.usuarios WHERE usuario='$Usuario';";
    $resultado = mysqli_query($con, $eliminar);
    mysqli_close($con);
    ?>
