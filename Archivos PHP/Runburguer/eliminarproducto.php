<?php
    include_once("conexion.php");
    $con = mysqli_connect($host, $usuario, $clave, $bd) or die('Fallo la conexion');
    mysqli_set_charset($con, "utf-8");

    $Nombreproducto=isset($_GET["nombre_producto"])?$_GET["nombre_producto"]:'';
   
    $eliminar = "DELETE FROM $bd.productos WHERE nombre_producto='$Nombreproducto';";
    $resultado = mysqli_query($con, $eliminar);
    mysqli_close($con);
    ?>
